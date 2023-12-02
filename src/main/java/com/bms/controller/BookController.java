package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.bms.service.BookService;
import com.bms.model.BookPojo;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired 
	BookService bookService;
	
	//http://localhost:6868/api/books
	@GetMapping("/books")
	List<BookPojo> getAllBooks(){
		List<BookPojo> allBooks = bookService.getAllBooks();
		System.out.println(allBooks);
		return allBooks;
	}
	
	//http://localhost:6868/api/books/6
	@GetMapping("/books/{bookId}")
	BookPojo getABook(@PathVariable("bookId") int bid) {
		return bookService.getABook(bid);
	}
	
	//http://localhost:6868/api/books/6
	@DeleteMapping("/books/{bookId}")
	void deleteBook(@PathVariable("bookId") int bid) {
		bookService.deleteBook(bid);
	}
	
	//http://localhost:6868/api/books
	@PostMapping("/books")
	BookPojo addBook(@RequestBody BookPojo newBookPojo) {
		return bookService.addBook(newBookPojo);
	}
	
}
