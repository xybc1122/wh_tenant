package com.wh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @ClassName UserApp
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/11 16:07
 **/
@SpringBootApplication
@MapperScan("com.wh.mapper")
@ServletComponentScan
public class TenantApp {

    public static void main(String[] args) {
        SpringApplication.run(TenantApp.class, args);
    }

}
