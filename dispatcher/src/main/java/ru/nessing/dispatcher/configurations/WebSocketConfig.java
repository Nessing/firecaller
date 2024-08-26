package ru.nessing.dispatcher.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.nessing.dispatcher.webSockets.FireStationWebSocket;
import ru.nessing.dispatcher.webSockets.WebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebSocketHandler(), "/my-websocket-endpoint").setAllowedOrigins("localhost:8080");
        registry.addHandler(fireStationWebSocket(), "/fire-station").setAllowedOrigins("localhost:8080");
    }

    @Bean
    public WebSocketHandler myWebSocketHandler() {
        return new WebSocketHandler();
    }

    @Bean
    public FireStationWebSocket fireStationWebSocket() {
        return new FireStationWebSocket();
    }
}
