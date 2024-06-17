package com.bookstore.bookies.repository;

import com.bookstore.bookies.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByFirstName(String username);
   Optional<User> findByEmail(String email);
}
