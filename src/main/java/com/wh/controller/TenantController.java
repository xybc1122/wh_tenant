package com.wh.controller;

import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.service.tenant.IWhWarehouseTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/tenantList")
    public ResponseBase getTenantList() {

        return JsonData.setResultSuccess(tenantService.selTenantList());
    }

}
