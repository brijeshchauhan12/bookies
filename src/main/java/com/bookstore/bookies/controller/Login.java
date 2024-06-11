package com.bookstore.bookies.controller;

import com.bookstore.bookies.model.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

@RestController
public class Login {

    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/loginUser")
    public String login(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
            if (authentication.isAuthenticated()) {
                return "Login successful";
            }
//            System.out.println(authRequest.toString());
        } catch (AuthenticationException e) {
            return "Login failed";
        }
        return authRequest.toString();
    }

}
