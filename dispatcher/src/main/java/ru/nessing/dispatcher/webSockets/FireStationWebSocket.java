package ru.nessing.dispatcher.webSockets;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class FireStationWebSocket extends TextWebSocketHandler {
    private final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        for (WebSocketSession client : sessions) {
            if (session.isOpen()) {
                System.out.println("New connection established: " + session.getId());
                client.sendMessage(new TextMessage("Сейчас в сети: " + sessions.size() + " клиентов"));
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        for (WebSocketSession client : sessions) {
            if (session.isOpen()) {
                client.sendMessage(new TextMessage("Сейчас в сети: " + sessions.size() + " клиентов"));
            }
        }
    }

    // Метод для отправки сообщений всем клиентам
    public void broadcastMessage(String message) throws IOException {
        for (WebSocketSession session : sessions) {
            if (session.isOpen()) {
                session.sendMessage(new TextMessage(message));
            }
        }
    }
}
