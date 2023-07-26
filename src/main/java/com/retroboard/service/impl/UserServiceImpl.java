package com.retroboard.service.impl;

import com.retroboard.model.User;
import com.retroboard.repository.UserRepository;
import com.retroboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }
}
