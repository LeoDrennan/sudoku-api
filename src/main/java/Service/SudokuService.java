package Service;

import Client.SudokuClient;
import Solver.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SudokuService implements ISudokuService {

    private final SudokuClient sudokuClient;

    @Autowired
    public SudokuService(SudokuClient sudokuClient) {
        this.sudokuClient = sudokuClient;
    }

    public int[][] solveBoard(int[][] request) {
        Board board = new Board(request);
        board.Validate();
        board.Optimise();
        board.Solve();

        return board.board;
    }

    public int getUnsolved() {

        return sudokuClient.getUnsolved();
    }
}
