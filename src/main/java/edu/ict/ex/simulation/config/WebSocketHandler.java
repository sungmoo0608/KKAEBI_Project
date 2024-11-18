package edu.ict.ex.simulation.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 여기서 받아오는 페이로드는 클라이언트에서 보낸 메시지가 된다.
        String payload = message.getPayload();
        System.out.println("payload: " + payload);

        // 해당 TextMessage는 서버가 클라이언트로 보내는 메시지가 된다.
        TextMessage textMessage = new TextMessage("Hello chatting server!");
        session.sendMessage(textMessage);
    }
}