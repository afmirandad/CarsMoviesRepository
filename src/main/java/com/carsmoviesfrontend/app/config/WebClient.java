package com.carsmoviesfrontend.app.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private static final String BASE_URL = "https://restcountries.com/v3.1/all";

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl(BASE_URL)
                .build();
    }
}