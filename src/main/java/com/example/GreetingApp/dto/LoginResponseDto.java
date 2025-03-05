package com.example.GreetingApp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponseDto {
    // Setters (optional if you need to modify the object after creation)
    // Getters
    private String message;
    private String token;

    // Constructor to initialize both fields
    public LoginResponseDto(String message, String token) {
        this.message = message;
        this.token = token;
    }

    // Default constructor (optional, but useful if you need to instantiate without values)
    public LoginResponseDto() {}

}