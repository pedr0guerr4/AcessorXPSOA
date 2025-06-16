package com.xpinc.assessor.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
            .info(new Info()
                .title("Assessor Virtual API (InMemory)")
                .version("1.0")
                .description("API para recomendação de investimentos – XP Inc."));
    }
}