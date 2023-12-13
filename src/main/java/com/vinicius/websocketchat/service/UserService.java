package com.vinicius.websocketchat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vinicius.websocketchat.repository.UserRepository;
import com.vinicius.websocketchat.user.Status;
import com.vinicius.websocketchat.user.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public void saveUser(User user){
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    public void disconnect(User user){
        var storedUser = userRepository.findById(user.getNickName()).
            orElse(null);

        if(storedUser != null){
            storedUser.setStatus(Status.OFFLINE);
            userRepository.save(storedUser);
        }

    }

    public List<User> findConnectedUsers(){
        return userRepository.findAllByStatus(Status.ONLINE);
    }
}
