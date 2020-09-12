package com.haagahelia.serverprogramming.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private String title;
	private String author;
	private int year; 
	private String isbn;
	private double price;

}
