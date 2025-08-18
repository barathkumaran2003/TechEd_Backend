package com.teched.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("TechEd API Documentation")
                        .description("API documentation for TechEd backend services")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Barathkumaran K S")
                                .email("your-email@example.com")
                                .url("https://yourwebsite.com")
                        )
                );
    }
}
