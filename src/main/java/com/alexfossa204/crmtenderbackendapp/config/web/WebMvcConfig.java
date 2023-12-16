package com.alexfossa204.crmtenderbackendapp.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig {

    //todo spring property
    public static final String allowedOrigin = "http://localhost:3000";

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/tenders/**").allowedOrigins(allowedOrigin);
                registry.addMapping("/managers/**").allowedOrigins(allowedOrigin);
            }
        };
    }

}
