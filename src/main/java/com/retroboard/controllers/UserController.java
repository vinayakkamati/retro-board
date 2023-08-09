package com.retroboard.controllers;

import com.retroboard.dtos.UserRequestDTO;
import com.retroboard.entities.UserEntity;
import com.retroboard.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public void createUser(@RequestBody UserEntity userEntity){
        userService.saveUser(userEntity);
    }

    @PostMapping(value = "/login")
    public UserEntity loginUser(@RequestBody UserRequestDTO userRequestDTO){
        return userService.validateUser(userRequestDTO);
    }
}
