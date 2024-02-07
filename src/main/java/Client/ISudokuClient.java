package Client;

import reactor.core.publisher.Mono;

public interface ISudokuClient {
    Mono<int[][]> getUnsolved();
}
