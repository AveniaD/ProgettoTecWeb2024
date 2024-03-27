package com.uniparthenope.innervision.config;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientConfig {

    private final WebClient webClient;

    public WebClientConfig() {
        this.webClient = WebClient.create();
    }

    public String fetchDataFromRemoteAPI() {

        return webClient.get()
                .uri("http://localhost:8080/api/innervision")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
