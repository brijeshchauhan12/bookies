package com.bookstore.bookies.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Data
@Component
public class AuthRequest {
    private String username;
    private String password;
}
