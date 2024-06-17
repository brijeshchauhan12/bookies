package com.bookstore.bookies.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class UserModelSignup {

    private String email;

    private String password;

    private String fullName;
}
