package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String email;
    private String password;
}
