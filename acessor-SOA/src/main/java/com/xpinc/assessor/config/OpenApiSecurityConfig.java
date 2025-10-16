package com.xpinc.assessor.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiSecurityConfig {
    @Bean
    OpenAPI customOpenAPI() {
		final String scheme = "bearerAuth";
		return new OpenAPI().components(new Components().addSecuritySchemes(scheme,
				new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
	}
}
