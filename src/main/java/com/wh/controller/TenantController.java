package com.wh.controller;

import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.dto.TenantStateDto;
import com.wh.service.tenant.IWhWarehouseTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName TenantController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/8 16:14
 **/
@RestController
@RequestMapping("/api/v1/tenant")
public class TenantController {


    @Autowired
    private IWhWarehouseTenantService tenantService;

    /**
     * 获得租户列表
     *
     * @return
     */
    @GetMapping("/tenantList")
    public ResponseBase getTenantList() {

        return JsonData.setResultSuccess(tenantService.selTenantList());
    }

    /**
     * 获得租户当前状态
     *
     * @param tenant
     * @return
     */
    @GetMapping("/selTenantStatus")
    public TenantStateDto getTenantStatus(@RequestParam("tenant") String tenant) {
        return tenantService.selTenantStatus(tenant);
    }

}
