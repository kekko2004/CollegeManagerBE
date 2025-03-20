package com.api.usercollege.repository;

import com.api.usercollege.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  <T extends User> extends JpaRepository<T, String> {
    Optional<T> findByEmail(String email);
    Optional<T> findByFreshman(String freshman);
}
