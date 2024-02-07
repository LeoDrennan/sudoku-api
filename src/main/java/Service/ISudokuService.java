package Service;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ISudokuService {
    int[][] getUnsolved();
    int[][] solveBoard(int[][] request);
}
