package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/23
 * Time:         20:14
 * Description : ********
 */
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiinfo()).select().apis(RequestHandlerSelectors.basePackage(
                        "com.example.demo.api"
                )).paths(PathSelectors.any()).build();
    }

    public ApiInfo apiinfo(){
        return new ApiInfoBuilder()
                .title("评估项目后台api文档")
                .description("版本1.0")
                .version("1.0").build();
    }
}
