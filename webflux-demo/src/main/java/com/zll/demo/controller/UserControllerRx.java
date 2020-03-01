package com.zll.demo.controller;

import com.zll.demo.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/user")
public class UserControllerRx {

    public Mono<ServerResponse> testMono(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromObject("hello webflux"));
    }


    @GetMapping("/get/{id}")
    public Mono<User> getUser(@PathVariable long id) {
        User user = User.builder().id(id).name("zs").salary(10000).build();
        return Mono.just(user);
    }
}
