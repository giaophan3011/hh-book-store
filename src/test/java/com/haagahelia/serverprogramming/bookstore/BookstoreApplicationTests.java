package com.haagahelia.serverprogramming.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.haagahelia.serverprogramming.bookstore.web.AuthController;
import com.haagahelia.serverprogramming.bookstore.web.BookController;
import com.haagahelia.serverprogramming.bookstore.web.BookRestController;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookstoreApplicationTests {
	@Autowired 
	private AuthController authController;
	@Autowired 
	private BookController bookController;
	@Autowired 
	private BookRestController bookRestController;
	
	@Test
	void contextLoads() {
		assertThat(authController).isNotNull();
		assertThat(bookController).isNotNull();
		assertThat(bookRestController).isNotNull();
	}

}
