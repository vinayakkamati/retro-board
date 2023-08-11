package com.retroboard.controllers;


import com.retroboard.dtos.UserDTO;
import com.retroboard.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public void createUser(@RequestBody @Valid UserDTO user){
        userService.saveUser(user);
    }

    @PostMapping(value = "/login")
    public UserDTO loginUser(@RequestBody UserDTO userDTO){
        return userService.validateUser(userDTO);
    }
}
