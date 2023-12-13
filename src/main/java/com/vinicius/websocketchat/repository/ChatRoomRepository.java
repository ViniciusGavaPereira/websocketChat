package com.vinicius.websocketchat.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vinicius.websocketchat.entities.ChatRoom;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {

    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
