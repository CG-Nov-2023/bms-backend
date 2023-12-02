package com.bms.service;

import java.util.List;

import com.bms.model.AuthorPojo;

public interface AuthorService {
	List<AuthorPojo> getAllAuthors();
	AuthorPojo getAAuthor();
	AuthorPojo addAuthor(AuthorPojo newAuthor);
	void deleteAuthor(int authorId);
	AuthorPojo updateAuthor(AuthorPojo updateAuthor);
	
}
