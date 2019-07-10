package com.wh.controller;

import com.wh.base.ResponseBase;
import com.wh.entity.role.WhUserRole;
import com.wh.entity.tenant.WhTenantInfo;
import com.wh.entity.tenant.WhWarehouseTenant;
import com.wh.service.tenant.IWhWarehouseTenantService;
import com.wh.toos.TenantConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName TenantSuperController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/9 15:26
 **/
@RestController
@RequestMapping("/api/v1/super-tenant")
public class TenantSuperController {
    @Autowired
    private IWhWarehouseTenantService tenantService;


    /**
     * @api {Post} api/v1/super-admin/insertTenant 新增创建租户信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup super-admin
     * @apiVersion 0.0.1
     * @apiDescription 用于新增用户信息以及下面的角色信息
     * @apiParamExample {json} 请求样例：
     * {
     * "dbPwd":"root",
     * "tenantName":"浙江创业3",
     * "dbName":"root",
     * "dbUrl":"192.168.1.230:3306/db3",
     * "tenant":"tenant3"
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/insertTenant")
    public ResponseBase insertTenant(@Valid @RequestBody WhWarehouseTenant tenant, BindingResult bindingResult) {
        return tenantService.saveTenant(tenant, bindingResult);
    }

    /**
     * @api {Post} api/v1/super-admin/insertTenantAndUser 超级管理员创建新增租户admin自己的用户表 跟 租户的用户表以及关联的角色
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup super-admin
     * @apiVersion 0.0.1
     * @apiDescription 用于超级管理员创建新增租户admin自己的用户表 跟 租户的用户表
     * @apiParamExample {json} 请求样例：
     * {
     * "pwd":"123456",
     * "userName":"admin1",
     * "tId":1,
     * "tenant":"tenant1"
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/insertTenantAndUser")
    public ResponseBase insertTenant(@Valid @RequestBody WhTenantInfo tenantInfo, BindingResult bindingResult) {
        return tenantService.saveTenantAdmin(tenantInfo, bindingResult);
    }

    /**
     * 超级管理员查询租户表里的超级管理员 菜单信息
     */
    @GetMapping("/selTenantMenu")
    public ResponseBase selTenantMenu(@RequestParam("tid") Integer tid) {
        return tenantService.selTenantMenu(tid);
    }


    /**
     * 超级管理员查询租户表里的超级管理员 角色信息
     */
    @GetMapping("/selTenantRole")
    public ResponseBase selTenantRole(@RequestParam("tid") Integer tid) {
        return tenantService.selTenantRole(tid);
    }


    /**
     * @api {Post} api/v1/super-admin/insertTenantAndMenu 超级管理员新增租户的菜单关联
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup super-admin
     * @apiVersion 0.0.1
     * @apiDescription 用于超级管理员新增租户的菜单关联
     * @apiParamExample {json} 请求样例：
     * {
     * "rid":1,
     * "menus":[10,11,12,13,14,15,16,17,18],
     * "tId":1
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/insertTenantAndMenu")
    public ResponseBase insertTenantAndMen(@Valid @RequestBody WhUserRole whUserRole, BindingResult bindingResult) {
        return tenantService.saveTenantAndMenu(whUserRole, bindingResult);
    }


    /**
     * @api {GET} /api/v1/super-admin/selTenantPermission 超级管理员查询租户权限列表进行配置
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup super-admin
     * @apiVersion 0.0.1
     * @apiDescription 用于超级管理员查询租户权限列表进行配置
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @GetMapping("/selTenantPermission")
    public ResponseBase tenantPermission(@RequestParam("tid") Integer tid) {
        return tenantService.selTenantPermission(tid);
    }

}
