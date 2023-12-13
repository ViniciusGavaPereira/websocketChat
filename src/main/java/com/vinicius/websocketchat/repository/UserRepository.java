package com.vinicius.websocketchat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vinicius.websocketchat.user.Status;
import com.vinicius.websocketchat.user.User;

public interface UserRepository extends MongoRepository<User, String> {
    
    List<User> findAllByStatus(Status status);
}
