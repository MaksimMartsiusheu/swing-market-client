package com.market;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SwingAppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
