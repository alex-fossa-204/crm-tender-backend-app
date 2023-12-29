package com.alexfossa204.crmtenderbackendapp.config.web;

import com.alexfossa204.crmtenderbackendapp.config.web.properties.WebConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfig {

    private final WebConfigProperties webConfigProperties;

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                webConfigProperties.getAllowedOrigins().forEach(allowedOrigin -> {
                    registry.addMapping("/tenders/**").allowedOrigins(allowedOrigin);
                    registry.addMapping("/managers/**").allowedOrigins(allowedOrigin);
                });
            }
        };
    }

}
