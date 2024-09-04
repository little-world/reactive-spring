package com.example.demo.controller;


import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TodoController {

@Autowired
TodoService todoService;

    @PostMapping("/todo")
    Mono<Todo> save(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @GetMapping("/todo")
    Flux<Todo> findAll() {
        return todoService.findAll();
    }

    @DeleteMapping("/todo/{id}")
    void delete(@PathVariable int id) {
        todoService.deleteById(id); }

    @GetMapping( value = "/todo/random", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Todo> getAllTodosRandomized() {
        return todoService.findAllRandomized();
    }
}