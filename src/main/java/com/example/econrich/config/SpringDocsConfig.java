package com.example.econrich.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SpringDocsConfig {

    @Bean
    public OpenAPI openAPI(){
        Info info = new Info()
                .title("econrich")
                .version("v1")
                .description("econrich 과제 API 문서 명세");

        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .info(info);

    }


}
