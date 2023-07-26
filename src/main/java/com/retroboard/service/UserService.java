package com.retroboard.service;

import com.retroboard.model.User;

import java.util.Optional;

public interface UserService {
    void saveUser(User user);
    Optional<User> findUser(Long id);
}
