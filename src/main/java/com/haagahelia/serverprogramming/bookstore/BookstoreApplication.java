package com.haagahelia.serverprogramming.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.haagahelia.serverprogramming.bookstore.domain.Book;
import com.haagahelia.serverprogramming.bookstore.domain.BookRepository;
import com.haagahelia.serverprogramming.bookstore.domain.Category;
import com.haagahelia.serverprogramming.bookstore.domain.CategoryRepository;
import com.haagahelia.serverprogramming.bookstore.domain.User;
import com.haagahelia.serverprogramming.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository, UserRepository urepository){
		return(args) -> {
				Category c1 = Category.builder().name("Action").build();
				Category c2 = Category.builder().name("Adventure").build();
				Category c3 = Category.builder().name("Classic").build();
				categoryRepository.save(c1);
				categoryRepository.save(c2);
				categoryRepository.save(c3);
				Book book1 = Book.builder()
						.author("Jean Austin")
						.title("Mocking bird")
						.isbn("0-306-40615-2")
						.year(2020)
						.price(50.0)
						.category(categoryRepository.findById(Long.valueOf(3)).get())
						.build();
				Book book2 = Book.builder()
						.author("Ernest Hemingway")
						.title("A Farewell to Arms")
						.isbn("0-306-40615-2")
						.year(1929)
						.price(50.0)
						.category(categoryRepository.findById(Long.valueOf(3)).get())
						.build();
				
				Book book3 = Book.builder()
						.author("Test delete")
						.title("Test delete")
						.isbn("Test delete")
						.year(1929)
						.price(50.0)
						.category(categoryRepository.findById(Long.valueOf(3)).get())
						.build();
				repository.save(book1);
				repository.save(book2);
				repository.save(book3);
				
				User user1 = User.builder().username("user").passwordHash("$2y$12$dsIwDSNc35tM9oNaCB0HwuRbkFLfnAVrpRqrMzUpbW/77eR.KBpv.").email("test1@test.fi").role("USER").build();						
				User user2 = User.builder().username("admin").passwordHash("$2y$12$dsIwDSNc35tM9oNaCB0HwuRbkFLfnAVrpRqrMzUpbW/77eR.KBpv.").email("test2@test.fi").role("ADMIN").build();
				urepository.save(user1);
				urepository.save(user2);
			};
		}

}
