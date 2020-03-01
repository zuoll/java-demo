package com.zll.demo.controller;

import com.zll.demo.Service.UserService;
import com.zll.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * <a>https://www.ibm.com/developerworks/cn/java/spring5-webflux-reactive/index.html</a>
 */
@RestController
@RequestMapping("/user")
public class UserController2 {

    private final UserService userService;


    @Autowired
    public UserController2(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = {"/get/all", "/list"})
    public Flux<User> getAll() {
        return this.userService.list();
    }


    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable final String id) {
        return this.userService.getById(id);
    }


    @PostMapping("/create")
    public Mono<User> createUser(@RequestBody final User user) {
        return this.userService.saveOrUpdate(user);
    }

    @PutMapping("/update/{id}")
    public Mono<User> updateUser(@PathVariable final String id, @RequestBody final User user) {
        Objects.requireNonNull(user);
        user.setUuid(id);
        return this.userService.saveOrUpdate(user);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<User> deleteUser(@PathVariable final String id) {
        return this.userService.deleteUser(id);
    }

}
