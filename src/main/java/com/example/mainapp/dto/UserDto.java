package com.example.mainapp.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDto {

    private String username;
    private String email;
    private Boolean isExpired;
    private LocalDateTime registeredOn;
    private String password;
}
