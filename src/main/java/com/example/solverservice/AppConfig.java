package com.example.solverservice;

import Client.SudokuClient;
import Service.SudokuService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        return WebClient.create("https://sudoku-api.vercel.app/api/dosuku");
    }
}
