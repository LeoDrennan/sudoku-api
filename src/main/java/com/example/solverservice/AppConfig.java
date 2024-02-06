package com.example.solverservice;

import Client.SudokuClient;
import Service.SudokuService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SudokuService sudokuService(SudokuClient sudokuClient) {
        return new SudokuService(sudokuClient);
    }

    @Bean
    public SudokuClient sudokuClient() {
        return new SudokuClient();
    }
}
