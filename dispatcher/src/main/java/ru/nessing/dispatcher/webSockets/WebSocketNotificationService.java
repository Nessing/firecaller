package ru.nessing.dispatcher.webSockets;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WebSocketNotificationService {
    private final FireStationWebSocket webSocket;

    public WebSocketNotificationService(FireStationWebSocket webSocket) {
        this.webSocket = webSocket;
    }

    // Метод для отправки уведомлений
    public void notifyClients(String message) {
        try {
            webSocket.broadcastMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
