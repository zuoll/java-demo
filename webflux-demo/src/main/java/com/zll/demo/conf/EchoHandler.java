package com.zll.demo.conf;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

/**
 * 在服务端要实现WebSocketHandler来处理WebSocket通讯
 * @see WebSocketHandler
 */
@Component
public class EchoHandler implements WebSocketHandler {
    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.send(session.receive()
                .map(msg->session.textMessage("echo=>"+msg.getPayloadAsText())));
    }
}
