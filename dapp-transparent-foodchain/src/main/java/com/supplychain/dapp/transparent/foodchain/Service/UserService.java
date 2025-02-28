package com.supplychain.dapp.transparent.foodchain.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplychain.dapp.transparent.foodchain.Model.User;
import com.supplychain.dapp.transparent.foodchain.Repository.UserRepository;

// src/main/java/com/example/auth/service/UserService.java
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User authenticate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
}

