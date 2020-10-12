package com.haagahelia.serverprogramming.bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.haagahelia.serverprogramming.bookstore.domain.Book;
import com.haagahelia.serverprogramming.bookstore.domain.BookRepository;
import com.haagahelia.serverprogramming.bookstore.domain.Category;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {
	@Autowired 
	private BookRepository bookRepository;
	
	@Test
	public void findByTitleShouldReturnBook () {
		List<Book>  books = bookRepository.findAllByTitle("A Farewell to Arms");
		assertThat (books).hasSize(1);
		assertThat (books.get(0).getAuthor()).isEqualTo("Ernest Hemingway");
	}
	
	@Test
	public void createNewBook () {
		Book book = Book.builder()
				.author("Test author")
				.title("Test title")
				.isbn("0-306-40615-2")
				.year(1929)
				.price(50.0)
				.category(Category.builder().name("Test").build())
				.build();
		Book savedBook = bookRepository.save(book);
		assertThat (savedBook.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook () {		
		long deletedRecords = bookRepository.deleteByTitle("Test delete");
		assertThat (deletedRecords ).isEqualTo(1);
	}

}
