package com.alexfossa204.crmtenderbackendapp.config.web.properties;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "spring.web-mvc")
@Value
public class WebConfigProperties {

    List<String> allowedOrigins;

}
