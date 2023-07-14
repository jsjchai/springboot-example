package com.github.jsjchai.springboot.demo.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {


    private OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("Springboot example")
                .description("Springboot example")
                .version("0.0.1"));
    }
}
