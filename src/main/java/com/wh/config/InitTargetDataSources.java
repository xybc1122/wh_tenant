package com.wh.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;
import com.wh.dds.DynamicDataSource;
import com.wh.entity.tenant.WhWarehouseTenant;
import com.wh.service.tenant.IWhWarehouseTenantService;
import com.wh.toos.Constants;
import com.wh.toos.TenantConstants;
import org.hibernate.validator.internal.util.ConcurrentReferenceHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
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
        setTenantConfig(
                tenantService.selTenantList());
    }


    public void setTenantConfig(List<String> tenantList) {
        for (String str : tenantList) {
            JSONObject t = JSONObject.parseObject(str);
            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://%s/%s?useUnicode=true&nullCatalogMeansCurrent=true&characterEncoding=utf-8&useSSL=false";
            druidDataSource.setUrl(String.format(URL, t.get("dbIp"), t.get("dbDatabase")));
            druidDataSource.setUsername(t.get("dbName").toString());
            druidDataSource.setPassword(t.get("dbPwd").toString());
            druidDataSource.setDbType("com.alibaba.druid.pool.DruidDataSource");
            TenantConstants.dataSourceMap.put(t.get("tenant"), druidDataSource);
        }
        targetDataSources.dynamicDataSource.setDataSources(TenantConstants.dataSourceMap);
        targetDataSources.dynamicDataSource.afterPropertiesSet();
        System.out.println(TenantConstants.dataSourceMap);

    }

}
