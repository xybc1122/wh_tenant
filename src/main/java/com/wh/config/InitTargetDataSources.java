package com.wh.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.wh.dds.DynamicDataSource;
import com.wh.entity.tenant.WhWarehouseTenant;
import com.wh.service.tenant.IWhWarehouseTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName InitTargetDataSources
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/12 14:36
 **/
@Component
@Order(0)
public class InitTargetDataSources implements CommandLineRunner {


    @Autowired
    private IWhWarehouseTenantService tenantService;

    @Autowired
    private DynamicDataSource dynamicDataSource;

    private static InitTargetDataSources targetDataSources;

    //通过@PostConstruct实现初始化bean之前进行的操作
    @PostConstruct
    public void init() {

        targetDataSources = this;
    }

    private static String URL = "jdbc:mysql://%s/%s?useUnicode=true&nullCatalogMeansCurrent=true&characterEncoding=utf-8&useSSL=false";

    /**
     * 这里配置启动加载数据源
     *
     * @param args
     */
    @Override
    public void run(String... args) {
        List<WhWarehouseTenant> tenantList = tenantService.selTenantList();
        Map<Object, Object> dataSourceMap = tenantList.stream().collect(Collectors.toMap(
                WhWarehouseTenant::getTenant, tenant -> {
                    DruidDataSource druidDataSource = new DruidDataSource();
                    druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
                    druidDataSource.setUrl(String.format(URL, tenant.getDbIp(), tenant.getDbDatabase()));
                    druidDataSource.setUsername(tenant.getDbName());
                    druidDataSource.setPassword(tenant.getDbPwd());
                    druidDataSource.setDbType("com.alibaba.druid.pool.DruidDataSource");
                    return druidDataSource;
                }
        ));
        targetDataSources.dynamicDataSource.setDataSources(dataSourceMap);
        targetDataSources.dynamicDataSource.afterPropertiesSet();
    }

}
