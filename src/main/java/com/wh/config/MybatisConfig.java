package com.wh.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.wh.dds.DynamicDataSource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Mybatis配置
 *
 * @author Louis
 * @date Oct 31, 2018
 */
@Configuration
@MapperScan("com.wh.mapper")
public class MybatisConfig {


    @Bean("master")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource master() {
        return DataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(master());
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactory SqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        // 配置数据源，此处配置为关键配置，如果没有将 dynamicDataSource作为数据源则不能实现切换
        mybatisSqlSessionFactoryBean.setDataSource(dynamicDataSource());
//        mybatisSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().
//                getResources("classpath:mapper/*/*.xml"));
        mybatisSqlSessionFactoryBean.setConfiguration(mybatisConfiguration());
        mybatisSqlSessionFactoryBean.setGlobalConfig(globalConfig());
        return mybatisSqlSessionFactoryBean.getObject();
    }

    /**
     * 这个设置 逻辑删除
     *
     * @return
     */
    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setSqlInjector(new LogicSqlInjector());
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        globalConfig.setDbConfig(dbConfig);
        return globalConfig;

    }
    /**
     * 这个配置 sql 打印
     *
     * @return
     */
    @Bean
    public MybatisConfiguration mybatisConfiguration() {
        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        mybatisConfiguration.setLogImpl(StdOutImpl.class);
        mybatisConfiguration.setMapUnderscoreToCamelCase(true);
        return mybatisConfiguration;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // 配置事务管理, 使用事务时在方法头部添加@Transactional注解即可
        return new DataSourceTransactionManager(dynamicDataSource());
    }


}
