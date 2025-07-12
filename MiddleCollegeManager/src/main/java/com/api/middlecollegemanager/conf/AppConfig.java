package com.api.middlecollegemanager.conf;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.readTimeout
                (Duration.ofSeconds(5)).
                connectTimeout(Duration.ofSeconds(5))
                .build();

    }
}