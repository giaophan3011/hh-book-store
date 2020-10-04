package com.haagahelia.serverprogramming.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.haagahelia.serverprogramming.bookstore.domain.Book;
import com.haagahelia.serverprogramming.bookstore.domain.BookRepository;
import com.haagahelia.serverprogramming.bookstore.domain.Category;
import com.haagahelia.serverprogramming.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository){
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
				repository.save(book1);
				repository.save(book2);
				
				
			};
		}

}
