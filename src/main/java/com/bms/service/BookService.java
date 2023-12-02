package com.bms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bms.model.BookPojo;


public interface BookService {
	List<BookPojo> getAllBooks();
	BookPojo getABook(int bId);
	BookPojo addBook(BookPojo newBook);
	void deleteBook(int bookId);
	BookPojo updateBook(BookPojo updateBook);
}
