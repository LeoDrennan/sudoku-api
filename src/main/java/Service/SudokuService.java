package Service;

import Client.ISudokuClient;
import Solver.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SudokuService implements ISudokuService {

    private final ISudokuClient sudokuClient;

    @Autowired
    public SudokuService(ISudokuClient sudokuClient) {
        this.sudokuClient = sudokuClient;
    }

    public int[][] solveBoard(int[][] request) {
        Board board = new Board(request);
        board.Validate();
        board.Optimise();
        board.Solve();

        return board.board;
    }

    public Mono<int[][]> getUnsolved() {
        return sudokuClient.getUnsolved();
    }
}
