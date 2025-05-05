package com.carsmoviesfrontend.app.services;

import com.carsmoviesfrontend.app.models.PagedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class MoviesService {
    private final WebClient webClient;

    public MoviesService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://carsmoviesinventoryproject-production.up.railway.app")
                .build();
    }

    public PagedResponse getAllMovies(int page) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/v1/carsmovies")
                        .queryParam("page", page)
                        .build())
                .retrieve()
                .bodyToMono(PagedResponse.class)
                .block();
    }
}