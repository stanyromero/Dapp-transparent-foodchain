package com.supplychain.dapp.transparent.foodchain.DTO;

// src/main/java/com/example/auth/dto/AuthResponse.java
public class AuthResponse {
    private String role;

    public AuthResponse(String role) {
        this.role = role;
    }
    
    // Getters and Setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}