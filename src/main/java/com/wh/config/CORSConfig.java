package com.wh.config;

import com.wh.interceoter.InterCenter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName CorsConfig
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/2 14:25
 **/
@Configuration
public class CORSConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterCenter()).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

//    @Override
//    public void addCorsMappings(CorsRegistry corsRegistry) {
//        // 允许跨域访问资源定义： /api/ 所有资源
//        corsRegistry.addMapping("/**")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .allowedOrigins("*")
//                .allowCredentials(true)
//                .maxAge(3600);
//    }
}
