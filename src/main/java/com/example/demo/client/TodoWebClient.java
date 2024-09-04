package com.example.demo.client;

import com.example.demo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TodoWebClient {
    private final WebClient webClient;

    @Autowired
    public TodoWebClient(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("http://localhost:8080")
                .build();
    }

    public Mono<Todo> createTodo(Mono<Todo> Todo) {
        return webClient.post().uri("/todo")
                .body(Todo, Todo.class)
                .retrieve()
                .bodyToMono(Todo.class);
    }

    public Flux<Todo> getTodos() {
        return webClient.get().uri("/todo")
                .retrieve()
                .bodyToFlux(Todo.class);
    }

    public Mono<Void> deleteTodo(int id) {
        return webClient.delete().uri("/todo/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Flux<Todo> getAllTodosRandomized() {
      return webClient.get().uri("/todo/random")
            .retrieve()
            .bodyToFlux(Todo.class);

    }
}