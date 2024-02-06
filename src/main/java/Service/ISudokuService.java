package Service;

public interface ISudokuService {
    int getUnsolved();
    int[][] solveBoard(int[][] request);
}
