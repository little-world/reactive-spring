package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

 //   private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HelloService helloService;

    @GetMapping("/hello/{name}")
    String sayHallo(@PathVariable String name) {
  //      logger.info("in sayHallo");
  //      logger.debug("debug in sayHallo");
        return helloService.toUpperCase(name);
    }

}
