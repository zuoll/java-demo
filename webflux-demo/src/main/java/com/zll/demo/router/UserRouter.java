package com.zll.demo.router;

import com.zll.demo.controller.CalculatorHandler;
import com.zll.demo.controller.UserControllerRx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Configuration
public class UserRouter {

    /**
     * @param userControllerRx
     * @return
     * @see RouterFunction
     * 手动定义路由。spring-cloud-gateway中也是这么操作的
     */
    @Bean
    public RouterFunction<ServerResponse> routerTest(UserControllerRx userControllerRx) {
        return RouterFunctions.route(RequestPredicates.GET("/user/test")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                userControllerRx::testMono);
    }

    /**
     * 配置路由{@link com.zll.demo.controller.CalculatorHandler}
     */

    public RouterFunction<ServerResponse> calRouter(@Autowired final CalculatorHandler calculatorHandler) {
        return RouterFunctions.route(RequestPredicates.path("/calc"), request ->
                request.queryParam("operate").map(op ->
                        Mono.justOrEmpty(ReflectionUtils.findMethod(CalculatorHandler.class, op, ServerRequest.class))
                                .flatMap(method -> (Mono<ServerResponse>) ReflectionUtils.invokeMethod(method, calculatorHandler, request))
                                .switchIfEmpty(ServerResponse.badRequest().build())
                                .onErrorResume(ex -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build()))
                        .orElse(ServerResponse.badRequest().build()));

    }
}

