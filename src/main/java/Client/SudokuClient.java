package Client;

import org.springframework.stereotype.Component;

@Component
public class SudokuClient implements ISudokuClient {
    public int getUnsolved() {
        return 1;
    }
}
