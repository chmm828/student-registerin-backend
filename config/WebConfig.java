package com.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @program: java-jssb
 * @description: 跨域处理
 * @author:  
 * @create: 2021-10-23 11:55
 **/
@Configuration
public class WebConfig  implements WebMvcConfigurer {
    @Override//实现跨域处理方法
    public void addCorsMappings(CorsRegistry registry) {
        registry
                //允许访问路径
                .addMapping("/**")
                //请求来源
                .allowedOrigins("http://localhost:8888/")
                //配置允许跨域访问的方法
                .allowedMethods("GET","POST","DELETE","PUT")
                //是否允许携带参数
                .allowCredentials(true)
                //请求头
//                .allowedHeaders()
                //最大响应时间,一个小时
                .maxAge(3600);
    }
}
