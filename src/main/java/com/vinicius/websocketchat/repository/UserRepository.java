package com.vinicius.websocketchat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vinicius.websocketchat.entities.Status;
import com.vinicius.websocketchat.entities.User;

public interface UserRepository extends MongoRepository<User, String> {
    
    List<User> findAllByStatus(Status status);
}
