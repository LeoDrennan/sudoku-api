package com.example.solverservice;

import Client.SudokuClient;
import Service.SudokuService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
    @Bean
    public SudokuService sudokuService(SudokuClient sudokuClient) {
        return new SudokuService(sudokuClient);
    }

    @Bean
    public SudokuClient sudokuClient(WebClient webClient) {
        return new SudokuClient(webClient);
    }

    @Bean
    public WebClient webClient() {

        return WebClient.builder()
                .baseUrl("https://sudoku-api.vercel.app/api/dosuku")
                .defaultCookie("cookie-name", "cookie-value")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
