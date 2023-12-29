package com.alexfossa204.crmtenderbackendapp.config.properties;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationPropertiesScan(basePackages = "com.alexfossa204.crmtenderbackendapp.config")
@EnableConfigurationProperties
@Configuration
public class DynamicPropertiesConfig {
}
