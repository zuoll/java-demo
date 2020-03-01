package com.zll.demo;

import com.zll.demo.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;
import java.util.Objects;
import java.util.UUID;

public class WebClientTest2 {
    public static void main(String[] args) {
//        testRest();

//        testSSE();

//        testWS();
        webTestClientDemo();
    }

    private static void testRest() {
        User user = User.builder().id(1).name("aa").salary(10000).uuid(UUID.randomUUID().toString()).build();
        WebClient webClient = WebClient.create("http://localhost:8080/user/create");
        Mono<User> userMono = webClient.post().uri("").accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class).exchange().flatMap(resp -> resp.bodyToMono(User.class));

        System.out.println(userMono.block());
    }

    public static void testSSE() {
        final WebClient client = WebClient.create();
        client.get()
                .uri("http://localhost:8080/sse/get/random")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .flatMapMany(response -> response.body(BodyExtractors.toFlux(new ParameterizedTypeReference<ServerSentEvent<String>>() {
                })))
                .filter(sse -> Objects.nonNull(sse.data()))
                .map(ServerSentEvent::data)
                .buffer(10)
                .doOnNext(System.out::println)
                .blockFirst();
    }

    public static void testWS() {
        final WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(URI.create("ws://localhost:8080/echo"), session ->
                session.send(Flux.just(session.textMessage("Hello")))
                        .thenMany(session.receive().take(2).map(WebSocketMessage::getPayloadAsText))
                        .doOnNext(System.out::println)
                        .then())
                .block(Duration.ofMillis(2000));
    }

    /**
     * spring-test
     *
     * @see org.springframework.test.web.reactive.server.WebTestClient
     */

    public static void webTestClientDemo() {
        final WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(URI.create("ws://localhost:8080/echo"), session ->
                session.send(Flux.just(session.textMessage("Hello")))
                        .thenMany(session.receive().take(2).map(WebSocketMessage::getPayloadAsText))
                        .doOnNext(System.out::println)
                        .then())
                .block(Duration.ofMillis(5000));
    }
}
