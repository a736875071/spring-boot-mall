package com.change.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author change
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.change.controller")
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    @Bean
    public Docket brandApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .genericModelSubstitutes(DeferredResult.class)
            .useDefaultResponseMessages(false)
            .forCodeGeneration(false)
            .pathMapping("/")
            //分组名称
            .groupName("商品品牌管理")
            .select()
            //api 包
            .apis(RequestHandlerSelectors.basePackage("com.change.controller.brand"))
            .build()
            .apiInfo(productApiInfo());
    }

    @Bean
    public Docket umsMember() {
        return new Docket(DocumentationType.SWAGGER_2)
            .genericModelSubstitutes(DeferredResult.class)
            .useDefaultResponseMessages(false)
            .forCodeGeneration(false)
            .pathMapping("/")
            .groupName("会员登录注册管理")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.change.controller.ums"))
            .build()
            .apiInfo(productApiInfo());
    }

    @Bean
    public Docket es() {
        return new Docket(DocumentationType.SWAGGER_2)
            .genericModelSubstitutes(DeferredResult.class)
            .useDefaultResponseMessages(false)
            .forCodeGeneration(false)
            .pathMapping("/")
            .groupName("全文检索")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.change.controller.es"))
            .build()
            .apiInfo(productApiInfo());
    }

    private ApiInfo productApiInfo() {
        ApiInfo apiInfo = new ApiInfo("系统数据接口文档",
            "文档描述。。。",
            "1.0.0",
            "API TERMS URL",
            "联系人邮箱",
            "license",
            "license url");
        return apiInfo;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html")
            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}