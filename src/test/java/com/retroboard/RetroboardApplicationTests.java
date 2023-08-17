package com.retroboard;

import com.retroboard.controllers.CommentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RetroboardApplicationTests {

	@Autowired
	private CommentController commentController;

	@Test
	void contextLoads() {
		assertThat(commentController).isNotNull();
	}

}
