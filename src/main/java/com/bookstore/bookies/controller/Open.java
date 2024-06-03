package com.bookstore.bookies.controller;

import com.bookstore.bookies.entity.User;
import com.bookstore.bookies.service.UserService;
import com.bookstore.bookies.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/open")
public class Open {
    @Autowired
    private UserServiceInterface userServiceInterface;
    @GetMapping("/test")
    public String Test(){
        return "Everything is working as it is supposed to be working";

    }
    @PostMapping("/saveNewUser")

    public User saveUser(@RequestBody User user){

        return userServiceInterface.saveUser(user);
    }

}
