package Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SudokuClient implements ISudokuClient {
    private final WebClient webClient;

    @Autowired
    public SudokuClient(WebClient webClient) {
        this.webClient = webClient;
    }

    // TODO: Hook this up to consume "https://sudoku-api.vercel.app/api/dosuku"
    public int[][] getUnsolved() {
        return new int[][] {
                {0, 0, 0, 6, 0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 9, 0, 6, 0},
                {0, 8, 0, 0, 0, 5, 0, 0, 3},
                {1, 0, 0, 4, 0, 0, 9, 0, 0},
                {8, 3, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0, 0, 0},
                {2, 5, 0, 3, 0, 7, 0, 9, 0},
                {0, 0, 1, 0, 0, 0, 0, 8, 4}
        };
    }
}
