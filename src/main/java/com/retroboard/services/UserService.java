package com.retroboard.services;

import com.retroboard.dtos.UserDTO;
import com.retroboard.entities.UserEntity;

import java.util.Optional;

public interface UserService {
    void saveUser(UserDTO user);
    Optional<UserEntity> findUser(Long id);

    UserDTO validateUser(UserDTO userDTO);
}
