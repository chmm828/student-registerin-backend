package com.server.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： 
 * @date ：Created in  2022/10/31 9:39
 * @description：接口文档配置
 * @modified By：
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

    /**
     * 创建接口文档
     * @return
     */
    @Bean
    public Docket createApi(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.server.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes( securitySchemes())
                .securityContexts(securityContexts());
    }

    /**
     * 设置文档信息
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("新生报道系统管理平台")
                .version("1.0.0")
                .contact(new Contact(" ","http://localhost:8001/doc.html","9800@qq.com"))
                .description("新生报道系统管理平台的接口文档")
                .build();

    }

    /**
     * 设置请求的信息
     * @return
     */

    private List<ApiKey> securitySchemes(){
        List<ApiKey> list = new ArrayList<>();
        ApiKey key = new ApiKey("Authorization","Authorization","Header");
        list.add(key);
        return list;
    }

    /**
     * 配置的security，对swggwer测试的权限
     * @return
     */
    private List<SecurityContext> securityContexts(){
        List<SecurityContext> list = new ArrayList<>();
        list.add(getSecurityContext());
        return  list;
    }

    /**
     * 得到授权路径
     * @return
     */
    private  SecurityContext getSecurityContext(){
        return SecurityContext
                .builder()
                .securityReferences(securityReferences())
                .forPaths(PathSelectors.regex("hello/.*"))
                .build();
    }

    /**
     * 给swgger授权，可以进行接口测试
     * @return
     */
    private List<SecurityReference> securityReferences(){
        List<SecurityReference> list = new ArrayList<>();
        //授权范围 全局
        AuthorizationScope scope = new AuthorizationScope("global","accessEverything");
        AuthorizationScope[] scopes = new  AuthorizationScope[1];
        scopes[0]=scope;
        list.add(new SecurityReference("Authorization",scopes));
        return list;
    }
}
