package com.retroboard;

import com.retroboard.entities.UserEntity;
import com.retroboard.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RetroBoardApplication {

	private final UserService userService;
	public RetroBoardApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RetroBoardApplication.class, args);
	}
	@PostConstruct
	public void postConstruct(){
		UserEntity userEntity = new UserEntity(1L, "Vinayak Kamati", "vk@gmail.com");
		userService.saveUser(userEntity);
	}
}
