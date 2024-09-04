package com.example.demo.service;


import com.example.demo.model.Todo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TodoService extends ReactiveCrudRepository<Todo, Integer>
{
    @Query("SELECT * FROM todos ORDER BY RAND()")
    Flux<Todo> findAllRandomized();
}