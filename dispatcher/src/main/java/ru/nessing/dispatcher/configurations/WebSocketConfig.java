package ru.nessing.dispatcher.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import ru.nessing.dispatcher.webSockets.FireStationWebSocket;
import ru.nessing.dispatcher.webSockets.WebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final FireStationWebSocket fireStationWebSocket;

    public WebSocketConfig(FireStationWebSocket fireStationWebSocket) {
        this.fireStationWebSocket = fireStationWebSocket;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebSocketHandler(), "/my-websocket-endpoint").setAllowedOrigins("localhost:8080");
//        registry.addHandler(fireStationWebSocket(), "/fire-station", "/my-websocket-endpoint").setAllowedOrigins("localhost:8080");
        registry.addHandler(fireStationWebSocket, "/fire-station")
                .setAllowedOrigins("http://localhost:5173")
//                .setAllowedOriginPatterns("*")
                .addInterceptors(new HttpSessionHandshakeInterceptor())
                .withSockJS();
    }

    @Bean
    public WebSocketHandler myWebSocketHandler() {
        return new WebSocketHandler();
    }
}
