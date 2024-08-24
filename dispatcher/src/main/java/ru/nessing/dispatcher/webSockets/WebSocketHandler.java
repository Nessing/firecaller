package ru.nessing.dispatcher.webSockets;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Обработка входящего сообщения от клиента
        String payload = message.getPayload();
        session.sendMessage(new TextMessage("start"));
        for (int i = 1; i <= 3; i++) {
            Thread.sleep(1000);
            session.sendMessage(new TextMessage(String.valueOf(i)));
        }
        session.sendMessage(new TextMessage("Received message: " + payload));
    }
}
