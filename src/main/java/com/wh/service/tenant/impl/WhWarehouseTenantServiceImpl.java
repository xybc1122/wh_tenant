package com.wh.service.tenant.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.ResponseBase;
import com.wh.entity.tenant.WhWarehouseTenant;
import com.wh.mapper.tenant.WhWarehouseTenantMapper;
import com.wh.service.tenant.IWhWarehouseTenantService;
import org.springframework.stereotype.Service;

import java.util.List;


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
    @Override
    public List<WhWarehouseTenant> selTenantList() {
        return this.list();
    }
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private IWhUserRoleService roleService;
//
//    @Autowired
//    private IWhUserRoleMenuService roleMenuService;
//
//    @Autowired
//    private IWhUserPermsService permsService;
//
//    @Autowired
//    private IWhUserMenuService menuService;
//
//
//    @Override
//    public ResponseBase selTenantRole(Integer tId) {
//        switchTenant(tId);
//        //3 查询角色信息返回
//
//        return JsonData.setResultSuccess(roleService.list());
//    }
//
//    @Override
//    public ResponseBase selTenantPermission(Integer tId) {
//        switchTenant(tId);
//        List<WhUserPerms> pList = permsService.lambdaQuery().select(WhUserPerms::getpId, WhUserPerms::getpName).list();
//        return JsonData.setResultSuccess(pList);
//    }
//
//    @Override
//    public ResponseBase selTenantMenu(Integer tId) {
//        //切换租户
//        switchTenant(tId);
//        return JsonData.setResultSuccess(menuService.serviceSelTreeList());
//    }
//
//    @Override
//    public ResponseBase saveTenant(WhWarehouseTenant tenant, BindingResult bindingResult) {
//        //1校验参数
//        String strBinding = BindingResultStore.bindingResult(bindingResult);
//        if (strBinding != null) return JsonData.setResultError(strBinding);
//        //2这里先查询 是否已有这个租户标识 不能重复
//        QueryWrapper<WhWarehouseTenant> tQuery = WrapperUtils.getQuery();
//        tQuery.select("tenant_id").eq("tenant", tenant.getTenant());
//        WhWarehouseTenant tOne = this.getOne(tQuery);
//        if (tOne != null) {
//            return JsonData.setResultSuccess("租户标识重复");
//        }
//        //3 创建租户信息
//        CheckUtils.saveResult(this.save(tenant));
//
//        return JsonData.setResultSuccess("success");
//    }
//
//    @Override
//    public ResponseBase saveTenantAdmin(UserInfo user, BindingResult bindingResult) {
//        //这里有分布式事物问题
//        String result;
//        //1 先新增用户
//        result = userService.insertUserInfoAndTenant(user, bindingResult);
//        if (result != null) {
//            return JsonData.setResultError(result);
//        }
//        //2 切换数据源 新增 租户表表里的数据
//
//        DynamicDataSourceContextHolder.setDataSourceKey(user.getTenant());
//
//        result = userService.insertUserInfoAndTenant(user, bindingResult);
//
//        if (result != null) {
//            return JsonData.setResultError(result);
//        }
//
//        return JsonData.setResultSuccess("success");
//    }
//
//    @Override
//    public ResponseBase saveTenantAndMenu(WhUserRole whUserRole, BindingResult bindingResult) {
//        String strBinding = BindingResultStore.bindingResult(bindingResult);
//        if (strBinding != null) return JsonData.setResultError(strBinding);
//
//        if (whUserRole.gettId() == null) {
//            return JsonData.setResultError("tid is null");
//        }
//        //1 通过 tid 查询租户
//        QueryWrapper<WhWarehouseTenant> tQuery = WrapperUtils.getQuery();
//        tQuery.eq("tenant_id", whUserRole.gettId());
//        WhWarehouseTenant tOne = this.getOne(tQuery);
//        //2切换租户
//        DynamicDataSourceContextHolder.setDataSourceKey(tOne.getTenant());
//        //2 设置角色菜单
//        roleMenuService.saveRoleMenu(whUserRole.getRid(), whUserRole.getMenus());
//
//        return JsonData.setResultSuccess("success");
//    }
//
//    public void switchTenant(Integer tId) {
//        //1 通过 tid 查询租户
//        QueryWrapper<WhWarehouseTenant> tQuery = WrapperUtils.getQuery();
//        tQuery.eq("tenant_id", tId);
//        WhWarehouseTenant tOne = this.getOne(tQuery);
//        if (tOne == null) {
//            throw new LsException("找不到租户信息");
//        }
//        //2切换租户
//        DynamicDataSourceContextHolder.setDataSourceKey(tOne.getTenant());
//    }
}
