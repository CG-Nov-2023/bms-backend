package com.bms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bms.dao.BookRepository;
import com.bms.dao.entity.AuthorEntity;
import com.bms.dao.entity.BookEntity;
import com.bms.exception.NoBooksAvailableException;
import com.bms.model.AuthorPojo;
import com.bms.model.BookPojo;

@SpringBootTest
public class BookServiceImplTest {
	
	@Mock
	BookRepository bookRepository;
	
	@InjectMocks
	BookServiceImpl bookServiceImpl;
	
	// here write your test methods
	// test methods are annotated with @Test
	
	@Test
	public void testGetAllBooks() {
		// create the mockito rule
		List<BookEntity> stubAllBooks = new ArrayList<BookEntity>();
		stubAllBooks.add(new BookEntity(101, "HarryPotter","", 222, "Fantasy", new AuthorEntity(4,"Rowling", "J.K", null)));
		
		when(bookRepository.findAll()).thenReturn(stubAllBooks);
		
		// get the expected output
		List<BookPojo> expectedAllBooks = new ArrayList<BookPojo>();
		expectedAllBooks.add(new BookPojo(101, "HarryPotter","", 222, "Fantasy", new AuthorPojo(4,"Rowling", "J.K", null)));
		
		// get the actual output
		// here we have call bookService.getAllBooks()
		List<BookPojo> actualAllBooks = bookServiceImpl.getAllBooks();
		
		// assert the expected and actual output
		assertEquals(expectedAllBooks.size(), actualAllBooks.size());
		verify(bookRepository).findAll(); // this line verifies whether the findAll method on bookRepositgory was called or not
		
	}
	
	@Test
	public void testGetAllBooksException() {
		// create mockito rule
		List<BookEntity> stubAllBooks = new ArrayList<BookEntity>();
		when(bookRepository.findAll()).thenReturn(stubAllBooks);
		
		// get the expected output
		String expectedMessage = "No Books Available!";
		
		// get actual output
		NoBooksAvailableException actualException = assertThrows(NoBooksAvailableException.class, ()->bookServiceImpl.getAllBooks());
		String actualMessage = actualException.getMessage();
		
		// assert the expected and actual output
		assertEquals(expectedMessage, actualMessage);
		verify(bookRepository).findAll();
		
	}

}
