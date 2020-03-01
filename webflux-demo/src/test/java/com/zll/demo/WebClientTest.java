package com.zll.demo;

import com.zll.demo.model.User;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebClientTest {
    public static void main(String[] args) {
//        testWebClient();

        test1();
    }

    /**
     * @see WebClient
     */
    private static void testWebClient() {
        WebClient client = WebClient.create("http://192.168.0.117:8080");

        Mono<User> result = client.get()
                .uri("user/get/{id}", 2)
                .retrieve()
                .bodyToMono(User.class);
        System.out.println(result.block());
    }

    public static void test1() {
        WebClient webClient = WebClient.create();
        Mono<String> mono = webClient.get().uri("https://www.baidu.com").retrieve().bodyToMono(String.class);
        System.out.println(mono.block());
    }
}
