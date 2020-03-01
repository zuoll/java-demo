package com.zll.demo.controller;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 服务器推送事件（server send sent [sse]),
 * sse单方向的 server->client
 *
 * websocket 双向的 server<->client
 */
@RestController
@RequestMapping("/sse")
public class ServerSendEventController {

    @GetMapping("/get/random")
    public Flux<ServerSentEvent<Integer>> getRandoms(){
        return  Flux.interval(Duration.ofSeconds(1))
                .map(seq-> Tuples.of(seq, ThreadLocalRandom.current().nextInt()))
                .map(data-> ServerSentEvent.<Integer>builder()
                        .event("random-data")
                        .id(Long.toString(data.getT1()))
                        .data(data.getT2()).build());

    }
}
