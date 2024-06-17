package com.bookstore.bookies.controller;
import com.bookstore.bookies.entity.User;
import com.bookstore.bookies.model.UserModelLogin;
import com.bookstore.bookies.model.UserModelSignup;
import com.bookstore.bookies.service.AuthenticationService;
import com.bookstore.bookies.service.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;



    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody UserModelSignup registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginReponse> authenticate(@RequestBody UserModelLogin loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginReponse loginResponse = new LoginReponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}