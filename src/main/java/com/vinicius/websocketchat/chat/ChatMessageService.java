package com.vinicius.websocketchat.chat;

import org.springframework.stereotype.Service;

import com.vinicius.websocketchat.service.ChatRoomService;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class ChatMessageService {
    
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage){
        var chatId = chatRoomService
        .getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(),true)
        .orElseThrow();

        chatMessage.setChatId(chatId);

        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId){
        var chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);

        return chatId.map(chatMessageRepository::findByChatId).orElse(new ArrayList<>());
        
    }


}
