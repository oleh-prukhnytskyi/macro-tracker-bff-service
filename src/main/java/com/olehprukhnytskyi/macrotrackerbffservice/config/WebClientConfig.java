package com.olehprukhnytskyi.macrotrackerbffservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient userWebClient(WebClient.Builder builder) {
        return builder.baseUrl("${services.user-service.url}").build();
    }

    @Bean
    public WebClient intakeWebClient(WebClient.Builder builder) {
        return builder.baseUrl("${services.intake-service.url}").build();
    }
}
