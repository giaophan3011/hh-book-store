package com.haagahelia.serverprogramming.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.haagahelia.serverprogramming.bookstore.domain.Category;
import com.haagahelia.serverprogramming.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Test
	public void findByTitleShouldReturnBook () {
		List<Category>  cats = categoryRepository.findAllByName("Action");
		assertThat (cats).hasSize(1);
	}
	
	@Test
	public void createNewCategory () {
		Category c3 = Category.builder().name("Test category").build();
		Category savedCat = categoryRepository.save(c3);
		assertThat (savedCat.getId()).isNotNull();
	}
	
}
