package com.bookstore.bookies.controller;

import com.bookstore.bookies.entity.User;
import com.bookstore.bookies.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class Restricted {

    @GetMapping("/test")
    public String Test(){
        return "This is a restricted resource";

    }


}
