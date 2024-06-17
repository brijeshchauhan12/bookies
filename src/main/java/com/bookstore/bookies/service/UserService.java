package com.bookstore.bookies.service;

import com.bookstore.bookies.entity.User;
import com.bookstore.bookies.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> allUsers() {

          return userRepository.findAll();
    }
}