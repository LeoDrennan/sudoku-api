package Service;

import reactor.core.publisher.Mono;

public interface ISudokuService {
    Mono<int[][]> getUnsolved();
    int[][] solveBoard(int[][] request);
}
