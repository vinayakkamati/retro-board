package com.retroboard;

import com.retroboard.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RetroBoardApplication {

	private final UserService userService;
	public RetroBoardApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RetroBoardApplication.class, args);
	}
}
