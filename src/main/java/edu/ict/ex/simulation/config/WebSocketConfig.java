package edu.ict.ex.simulation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    // 만든 웹소켓 핸들러
    private final WebSocketHandler webSocketHandler;

    public WebSocketConfig(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // protocol(http), host(localhost), port(8282)가 모두 동일해야 동일한 Origin이라고 한다.
        // 즉, 여기서 setAllowedOrigins("*")는 모든 Origin을 허용한다는 뜻
        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
    }
}