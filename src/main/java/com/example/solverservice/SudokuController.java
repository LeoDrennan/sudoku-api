package com.example.solverservice;

import Service.ISudokuService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class SudokuController {
    private final ISudokuService sudokuService;

    @Autowired
    public SudokuController(ISudokuService sudokuService) {
        this.sudokuService = sudokuService;
    }

    @GetMapping("/new-board")
    public ResponseEntity<int[][]> getUnsolved() {
        int [][] board = sudokuService.getUnsolved();

        return ResponseEntity.ok(board);
    }

    @PostMapping("/solve")
    public ResponseEntity<int[][]> solvePuzzle(@RequestBody int[][] request) {
        int[][] solvedBoard = sudokuService.solveBoard(request);

        return ResponseEntity.ok(solvedBoard);
    }

    @GetMapping("/solve-external")
    public ResponseEntity<int[][]> solveExternalPuzzle() {
        int[][] unsolved = sudokuService.getUnsolved();
        int[][] solved = sudokuService.solveBoard(unsolved);

        return ResponseEntity.ok(solved);
    }
}
