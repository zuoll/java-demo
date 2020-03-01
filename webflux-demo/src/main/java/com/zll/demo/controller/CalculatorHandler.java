package com.zll.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.function.BiFunction;

@Component
public class CalculatorHandler {

    public Mono<ServerResponse> add(ServerRequest request) {
        return this.calc(request,(v1,v2)->v1+v2);
    }

    public Mono<ServerResponse> subtract(ServerRequest request) {
        return this.calc(request,(v1,v2)->v1-v2);
    }

    public Mono<ServerResponse> miltiply(ServerRequest request) {
        return this.calc(request,(v1,v2)->v1*v2);
    }

    public Mono<ServerResponse> divide(ServerRequest request) {
        return this.calc(request,(v1,v2)->v1/v2);
    }

    private Mono<ServerResponse> calc(ServerRequest request, BiFunction<Integer, Integer, Integer> calcFunction) {
        Tuple2<Integer, Integer> tuple2 = this.getTuples(request);

        return ServerResponse.ok()
                .body(Mono.just(calcFunction.apply(tuple2.getT1(), tuple2.getT2())), Integer.class);
    }

    private Tuple2<Integer, Integer> getTuples(ServerRequest request) {
        return Tuples.of(this.parseParam(request, "v1"), this.parseParam(request, "v2"));
    }

    private int parseParam(ServerRequest request, String param) {
        try {
            String s = request.queryParam(param).orElse("0");
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
