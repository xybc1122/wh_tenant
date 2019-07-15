package com.wh.service.tenant.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.config.InitTargetDataSources;
import com.wh.dds.DynamicDataSourceContextHolder;
import com.wh.dto.TenantStateDto;
import com.wh.entity.perms.WhUserPerms;
import com.wh.entity.role.WhUserRole;
import com.wh.entity.tenant.WhTenantInfo;
import com.wh.entity.tenant.WhWarehouseTenant;
import com.wh.entity.user.UserInfo;
import com.wh.exception.LsException;
import com.wh.mapper.tenant.WhWarehouseTenantMapper;
import com.wh.service.menu.IWhUserMenuService;
import com.wh.service.perms.IWhUserPermsService;
import com.wh.service.redis.RedisService;
import com.wh.service.rm.IWhUserRoleMenuService;
import com.wh.service.role.IWhUserRoleService;
import com.wh.service.tenant.IWhTenantInfoService;
import com.wh.service.tenant.IWhWarehouseTenantService;
import com.wh.service.ur.IWhUserRoleUserService;
import com.wh.service.user.IWhUserService;
import com.wh.store.BindingResultStore;
import com.wh.toos.Constants;
import com.wh.utils.CheckUtils;
import com.wh.utils.WrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * <p>
 * 租户表 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-11
 */
@Service
public class WhWarehouseTenantServiceImpl extends ServiceImpl<WhWarehouseTenantMapper, WhWarehouseTenant> implements IWhWarehouseTenantService {

    @Autowired
    private WhWarehouseTenantMapper tenantMapper;

    @Autowired
    private IWhUserService userService;

    @Autowired
    private IWhUserRoleUserService ruService;

    @Autowired
    private IWhTenantInfoService tenantInfoService;
    @Autowired
    private IWhUserMenuService menuService;

    @Autowired
    private IWhUserRoleService roleService;

    @Autowired
    private InitTargetDataSources tDateSources;

    @Autowired
    private IWhUserRoleMenuService roleMenuService;

    @Autowired
    private IWhUserPermsService permsService;

    @Autowired
    private RedisService redisService;

    @Override
    public List<String> selTenantList() {
        //看缓存有没有数据
        Set<String> keys = redisService.getKeys(Constants.TENANT_KEY);
        if (keys == null || keys.size() <= 0) {
            //去数据库查询
            List<WhWarehouseTenant> tenantList = tenantMapper.findTenantList();
            if (tenantList != null && tenantList.size() > 0) {
                List<String> strT = new ArrayList<>();
                //存入redis
                for (WhWarehouseTenant t : tenantList) {
                    strT.add(JSON.toJSONString(t));
                    redisService.setString(RedisService.redisTenantKey(t.getTenant()), JSON.toJSONString(t));
                }
                //返回数据
                return strT;
            }
        }
        //循环查询 key
        return setTenants(keys);
    }

    public List<String> setTenants(Set<String> keys) {
        List<String> tenants = new ArrayList<>();
        for (String str : keys) {
            System.out.println(redisService.getStringKey(str));
            tenants.add(redisService.getStringKey(str));
        }
        return tenants;
    }


    @Override
    public TenantStateDto selTenantStatus(String tenant) {

        return tenantMapper.getTenantStatus(tenant);
    }


    @Override
    public ResponseBase selTenantMenu(Integer tId) {
        //切换租户
        switchTenant(tId);
        return JsonData.setResultSuccess(menuService.serviceSelTreeList());
    }

    @Override
    public ResponseBase saveTenant(WhWarehouseTenant tenant, BindingResult bindingResult) {
        //1校验参数
        String strBinding = BindingResultStore.bindingResult(bindingResult);
        if (strBinding != null) return JsonData.setResultError(strBinding);
        //2这里先查询 是否已有这个租户标识 不能重复
        QueryWrapper<WhWarehouseTenant> tQuery = WrapperUtils.getQuery();
        tQuery.select("tenant_id").eq("tenant", tenant.getTenant());
        WhWarehouseTenant tOne = this.getOne(tQuery);
        if (tOne != null) {
            return JsonData.setResultSuccess("租户标识重复");
        }
        //3 创建租户信息
        CheckUtils.saveResult(this.save(tenant));
        List<String> tList = new ArrayList<>();
        tList.add(JSON.toJSONString(tenant));
        //放入全局 租户Map;
        tDateSources.setTenantConfig(tList);

        //存入redis
        redisService.setString(RedisService.redisTenantKey(tenant.getTenant()), JSON.toJSONString(tenant));

        return JsonData.setResultSuccess("success");
    }

    @Override
    public ResponseBase saveTenantAdmin(WhTenantInfo tenantInfo, BindingResult bindingResult) {
        //这里有分布式事物问题
        //校验参数
        String strBinding = BindingResultStore.bindingResult(bindingResult);
        if (strBinding != null) return JsonData.setResultError(strBinding);
        //1 先新增租户用户信息
        CheckUtils.saveResult(tenantInfoService.save(tenantInfo));

        //2 切换数据源 新增 租户表表里的数据
        UserInfo user = tenantInfo.getUser();
        switchTenant(user.gettId());
        //3 新增租户用户
        String result = userService.insertUserInfoAndTenant(user);
        if (result != null) {
            throw new LsException(result);
        }
        //4 新增租户角色
        ruService.saveListRole(user.getUid(), user.getRids());
        return JsonData.setResultSuccess("success");
    }


    @Override
    public ResponseBase saveTenantAndMenu(WhUserRole whUserRole, BindingResult bindingResult) {
        String strBinding = BindingResultStore.bindingResult(bindingResult);
        if (strBinding != null) return JsonData.setResultError(strBinding);

        if (whUserRole.gettId() == null) {
            return JsonData.setResultError("tid is null");
        }
        //1 通过 tid 查询租户
        switchTenant(whUserRole.gettId());
        //2 设置角色菜单
        roleMenuService.saveRoleMenu(whUserRole.getRid(), whUserRole.getMenus());

        return JsonData.setResultSuccess("success");
    }

    private void switchTenant(Integer tId) {
        //1 通过 tid 查询租户
        QueryWrapper<WhWarehouseTenant> tQuery = WrapperUtils.getQuery();
        tQuery.eq("tenant_id", tId);
        WhWarehouseTenant tOne = this.getOne(tQuery);
        if (tOne == null || tOne.getTenant() == null) {
            throw new LsException("找不到租户信息");
        }
        //2切换租户
        DynamicDataSourceContextHolder.setDataSourceKey(tOne.getTenant());
    }
}
