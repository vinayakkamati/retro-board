package com.retroboard.services;

import com.retroboard.entities.UserEntity;

import java.util.Optional;

public interface UserService {
    void saveUser(UserEntity userEntity);
    Optional<UserEntity> findUser(Long id);
}
