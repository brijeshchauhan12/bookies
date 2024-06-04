package com.bookstore.bookies.service;

import com.bookstore.bookies.entity.User;
import com.bookstore.bookies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser=userRepository.findByFirstName(username);
        if(optionalUser.isEmpty()){
            throw  new UsernameNotFoundException("User not found in database");
        }

        User user =optionalUser.get();
        GrantedAuthority authority=new SimpleGrantedAuthority("USER");
        return new org.springframework.security.core.userdetails.User(user.getFirstName(),user.getPassword(), Collections.singleton(authority));

    }
}
