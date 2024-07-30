package com.coderscampus.Assignment14.domain;
import lombok.Data;

@Data
public class User {

    private Long userId;
    private String username;

    public User(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }
}
