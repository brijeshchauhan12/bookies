package com.bookstore.bookies.service;

import com.bookstore.bookies.entity.User;
import com.bookstore.bookies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements  UserServiceInterface{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        user.setPassword(encoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
