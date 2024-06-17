package com.bookstore.bookies.controller;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class LoginReponse {
    @Getter
    private String token;

    private long expiresIn;

    // Getters and setters...
}