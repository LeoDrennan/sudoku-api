package Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SudokuClient implements ISudokuClient {
    private final WebClient webClient;

    @Autowired
    public SudokuClient(WebClient webClient) {
        this.webClient = webClient;
    }

    // TODO: Hook this up to consume "https://sudoku-api.vercel.app/api/dosuku"
    public Mono<int[][]> getUnsolved() {
        Mono<Response> response = webClient.get()
                .retrieve()
                .bodyToMono(Response.class);

        return response.map(Response::toBoard);
    }
}
