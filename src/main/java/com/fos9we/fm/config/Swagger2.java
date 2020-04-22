package com.fos9we.fm.config;
/**
 * 配置swagger2工具，用来调试接口
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
	@Bean
    public Docket createRestApi() {
        /*
        通过createRestApi创建docket
        apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
        select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
        扫描com.fos9we.fm.web.controller包下面定义的方法作为展示的RestFul api，产生文档内容
         */
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
        		.select()
                .apis(RequestHandlerSelectors.basePackage("com.fos9we.fm.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /*
    定义展示的信息，例如标题、描述、版本等
     */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        		.title("b2b农贸市场api")
        		.description("用于后台展示的api文档")
                .termsOfServiceUrl("http://127.0.0.1:8080/farm_products")
                .version("1.0")
                .build();
    }
}
