package com.supplychain.dapp.transparent.foodchain.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplychain.dapp.transparent.foodchain.DTO.AuthRequest;
import com.supplychain.dapp.transparent.foodchain.DTO.AuthResponse;
import com.supplychain.dapp.transparent.foodchain.Model.User;
import com.supplychain.dapp.transparent.foodchain.Service.UserService;


// src/main/java/com/example/auth/controller/AuthController.java
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        User user = userService.authenticate(username,password);

        if (user != null) {
            return ResponseEntity.ok(new AuthResponse(user.getRole()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials");
        }
    }
}
