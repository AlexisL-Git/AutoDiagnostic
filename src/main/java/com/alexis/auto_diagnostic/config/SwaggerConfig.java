package com.alexis.auto_diagnostic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Health Diagnostic API")
                .version("1.0")
                .description("API for managing health diagnostics")
                .contact(new Contact()
                    .name("Alexis Leroy")
                    .email("alexis.leroy.consulting@gmail.com")))
            .externalDocs(new ExternalDocumentation()
                .description("Project GitHub")
                .url("https://github.com/AlexisL-Git/AutoDiagnostic"));
    }
}
