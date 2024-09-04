package com.example.demo.controller;

import com.example.demo.client.TodoWebClient;
import com.example.demo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ClientController {
    @Autowired
    TodoWebClient todoWebClient;

    @GetMapping("/todo-client")
    public Flux<Todo> getTodos (){
        return todoWebClient.getTodos()
                //  some example operators
                .filter(td -> td.id() > 2)
                .take(1);
    }
}
