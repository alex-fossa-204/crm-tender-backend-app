package com.alexfossa204.crmtenderbackendapp.config.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("crm-tender-backend-app")
                .pathsToMatch("/**")
                .packagesToScan("com.alexfossa204.crmtenderbackendapp.controller")
                .build();
    }

    @Bean
    public OpenAPI affinityBankOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("CRM Tender Backend Application")
                        .description("Данный сервис предназначен для управления данными тендоров, лотов, ведения учета сотрудников")
                        .version("v1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("CRM Tender Backend Application Wiki Документация")
                        .url("https://google.com"));
    }

}
