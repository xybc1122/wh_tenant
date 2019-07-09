package com.wh.service.tenant;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.dto.TenantStateDto;
import com.wh.entity.role.WhUserRole;
import com.wh.entity.tenant.WhTenantInfo;
import com.wh.entity.tenant.WhWarehouseTenant;
import com.wh.entity.user.UserInfo;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * <p>
 * 租户表 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-11
 */
public interface IWhWarehouseTenantService extends IService<WhWarehouseTenant> {

    /**
     * 获得所有租户信息
     *
     * @return
     */
    List<WhWarehouseTenant> selTenantList();

    TenantStateDto selTenantStatus(String tenant);

    /**
     * 超级管理员 查询租户的角色表
     */
    ResponseBase selTenantRole(Integer tId);


    /**
     * 超级管理员查询租户权限列表进行配置
     */
    ResponseBase selTenantPermission(Integer tId);


    /**
     * 超级管理员查询租户的菜单
     */
    ResponseBase selTenantMenu(Integer tId);

    /**
     * 超级管理员新增租户
     */

    ResponseBase saveTenant(WhWarehouseTenant tenant, BindingResult bindingResult);


    /**
     * 超级管理员新增租户 admin
     */
    ResponseBase saveTenantAdmin(WhTenantInfo tenantInfo, BindingResult bindingResult);


    /**
     * 超级管理员创建  租户 admin 关联的  菜单查看信息
     */
    ResponseBase saveTenantAndMenu(WhUserRole whUserRole, BindingResult bindingResult);
}
