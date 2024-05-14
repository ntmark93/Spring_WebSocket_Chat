package com.project.own.socialapp.chat;

import com.project.own.socialapp.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    private MessageType type;
    private String content;
    private User sender;

}