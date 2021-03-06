package com.haagahelia.serverprogramming.bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book,Long> {
	List<Book> findAllByTitle (String title);
	long deleteByTitle (String title);
	 	
}
