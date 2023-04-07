package com.alexfossa204.crmtenderbackendapp.config.mapstruct;

import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.UUID;

@Configuration
public class MapstructConfig {

    public static final String GENERATE_UUID_EXPRESSION = "java(com.alexfossa204.crmtenderbackendapp.config.mapstruct.MapstructConfig.generateUuid())";
    public static final String GENERATE_LOCAL_DATE_TIME_EXPRESSION = "java(com.alexfossa204.crmtenderbackendapp.config.mapstruct.MapstructConfig.generateLocalDateTime())";

    public static UUID generateUuid() {
        return UUID.randomUUID();
    }

    public static LocalDateTime generateLocalDateTime() {
        return LocalDateTime.now();
    }

    //TODO попробовать объявить это в интерфейсе

}
