package com.zll.demo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebSocketConfig {

    /**
    注册EchoHandler到WebSocketHandler
     * @see WebSocketHandler
     */
    @Bean
    public HandlerMapping webSocketMapping(@Autowired final EchoHandler echoHandler){
        final Map<String, WebSocketHandler> map = new HashMap<>(1);
        map.put("/echo",echoHandler);

        final SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        simpleUrlHandlerMapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
        simpleUrlHandlerMapping.setUrlMap(map);
        return simpleUrlHandlerMapping;
    }

    /**
     * WebSocketHandler关联到Flux
     *
     */
    @Bean
    public WebSocketHandlerAdapter webSocketHandlerAdapter(){
        return new WebSocketHandlerAdapter();
    }


}
