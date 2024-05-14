package com.project.own.socialapp.config.WebSocket;

import com.project.own.socialapp.chat.ChatMessage;
import com.project.own.socialapp.chat.MessageType;
import com.project.own.socialapp.model.User;
import com.project.own.socialapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messagingTemplate;
    private final UserRepository userRepository;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        Integer userId = (Integer) headerAccessor.getSessionAttributes().get("username");
        if (userId != null) {
            User user = userRepository.findById(userId).orElse(null);
            String userName = user.getFirstName() + user.getLastName();
            log.info("user disconnected: {}", userName);
            var chatMessage = ChatMessage.builder()
                    .type(MessageType.LEAVER)
                    .sender(user)
                    .build();
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }

}