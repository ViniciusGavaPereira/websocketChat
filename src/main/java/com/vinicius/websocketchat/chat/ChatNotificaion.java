package com.vinicius.websocketchat.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatNotificaion {

    private String id;
    private String senderId;
    private String recipientId;
    private String content;
    

}

