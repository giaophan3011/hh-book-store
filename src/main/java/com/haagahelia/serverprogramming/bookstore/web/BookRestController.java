package com.haagahelia.serverprogramming.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.haagahelia.serverprogramming.bookstore.domain.Book;
import com.haagahelia.serverprogramming.bookstore.domain.BookRepository;

@RestController
public class BookRestController {
	@Autowired
	BookRepository bookRepository;
	@GetMapping("/books")
	public List<Book> getBooks () {
		return (List<Book>) bookRepository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Book getBook (@PathVariable("id")Long bookId) {	
		return bookRepository.findById(bookId)
				.get();				
	}

}
