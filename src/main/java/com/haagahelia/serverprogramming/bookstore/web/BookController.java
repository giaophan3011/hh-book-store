package com.haagahelia.serverprogramming.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.haagahelia.serverprogramming.bookstore.domain.Book;
import com.haagahelia.serverprogramming.bookstore.domain.BookRepository;
import com.haagahelia.serverprogramming.bookstore.domain.CategoryRepository;


@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/")
	public String getIndexPage (Model model) {
		model.addAttribute("booklist", bookRepository.findAll());	
		return "booklist";
	}
	
	@GetMapping("/booklist")
	public String getBooklist (Model model) {	
		model.addAttribute("booklist", bookRepository.findAll());		
		return "booklist";
	}
	
	@GetMapping("/addbook")
	public String addBook(Model model) {	
		model.addAttribute("book", new Book());		
		model.addAttribute("categories", categoryRepository.findAll());		
		return "addbook";
	}
	
	@PostMapping(value="/save")
	public String save(Book book){
		bookRepository.save(book);
		return"redirect:/booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook (@PathVariable("id")Long bookId, Model model) {	
		bookRepository.deleteById(bookId);		
		return "redirect:../booklist";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook (@PathVariable("id")Long bookId, Model model) {
		Book book = bookRepository.findById(bookId).get();
		model.addAttribute("book", book);		
		return "editbook";
	}
	
	@PostMapping(value="/edit/save")
	public String change(Book book){
		//bookRepository.deleteById(book.getId());
		bookRepository.save(book);
		return "redirect:../booklist";
	}
}
