package ru.nessing.dispatcher.webSockets;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashSet;
import java.util.Set;

public class FireStationWebSocket extends TextWebSocketHandler {
    private final Set<WebSocketSession> sessions = new HashSet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        for (WebSocketSession client : sessions) {
            client.sendMessage(new TextMessage("Сейчас в сети: " + sessions.size() + " клиентов"));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        for (WebSocketSession client : sessions) {
            client.sendMessage(new TextMessage("Сейчас в сети: " + sessions.size() + " клиентов"));
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Обработка входящего сообщения от клиента
        String payload = message.getPayload();
        if (payload.equals("updatePerson")) {
            for (WebSocketSession client : sessions) {
                client.sendMessage(new TextMessage("updatePerson"));
            }
        }
        if (payload.equals("updateStatus")) {
            for (WebSocketSession client : sessions) {
                client.sendMessage(new TextMessage("updateStatus"));
            }
        }
    }
}
