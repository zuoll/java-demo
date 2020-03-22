package com.zll.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/say")
    public String say(String name) {
        return "hello," + name;
    }
}
