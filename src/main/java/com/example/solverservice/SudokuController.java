package com.example.solverservice;

import Service.ISudokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SudokuController {
    private final ISudokuService sudokuService;

    @Autowired
    public SudokuController(ISudokuService sudokuService) {
        this.sudokuService = sudokuService;
    }

    @GetMapping("/new")
    public int getUnsolved() {
        return sudokuService.getUnsolved();
    }

    @PostMapping("/solve")
    public int[][] solvePuzzle(@RequestBody int[][] request){
        return sudokuService.solveBoard(request);
    }

    @GetMapping("/external")
    public int[][] solveExternalPuzzle() {
        return new int[][]{};
    }
}
