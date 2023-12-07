package com.bms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.BookRepository;
import com.bms.dao.entity.AuthorEntity;
import com.bms.dao.entity.BookEntity;
import com.bms.exception.NoBooksAvailableException;
import com.bms.model.AuthorPojo;
import com.bms.model.BookPojo;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<BookPojo> getAllBooks() {
		List<BookEntity> allBooksEntity = bookRepository.findAll();
		// copy the collection of BookEntity into a collection BookPOjo
		List<BookPojo> allBooksPojo = new ArrayList<BookPojo>();
		if(allBooksEntity.isEmpty()) {
			throw new NoBooksAvailableException();
		}
		for(BookEntity eachBookEntity: allBooksEntity) {
			BookPojo eachBookPojo = new BookPojo();
			BeanUtils.copyProperties(eachBookEntity, eachBookPojo);
			AuthorPojo authorPojo = new AuthorPojo();
			BeanUtils.copyProperties(eachBookEntity.getAuthorEntity(), authorPojo);
			eachBookPojo.setAuthorPojo(authorPojo);
			
			allBooksPojo.add(eachBookPojo);
			
		}
		System.out.println(allBooksPojo);
		return allBooksPojo;
	}

	@Override
	public BookPojo getABook(int bId) {
		BookPojo fetchedBookPojo = null;
		Optional<BookEntity> fetchedBookEntityOptional = bookRepository.findById(bId);
		if(fetchedBookEntityOptional.isPresent()) {
			BookEntity fetchedBookEntity = fetchedBookEntityOptional.get();
			fetchedBookPojo = new BookPojo();
			BeanUtils.copyProperties(fetchedBookEntity, fetchedBookPojo);
			AuthorPojo authorPojo = new AuthorPojo();
			BeanUtils.copyProperties(fetchedBookEntity.getAuthorEntity(), authorPojo);
			fetchedBookPojo.setAuthorPojo(authorPojo);
		}
		return fetchedBookPojo;
	}

	@Override
	public BookPojo addBook(BookPojo newBookPojo) {
		// copy the incomming bookPojo to a bookentity object
		BookEntity bookEntity = new BookEntity();
		BeanUtils.copyProperties(newBookPojo, bookEntity);
		AuthorEntity authorEntity = new AuthorEntity();
		BeanUtils.copyProperties(newBookPojo.getAuthorPojo(), authorEntity);
		bookEntity.setAuthorEntity(authorEntity);
		// save the entity object
		bookRepository.save(bookEntity);
		// flush the object - the auto generated primary key is stored in the entity object
		bookRepository.flush();
		// copy the entity object to a pojo object
		newBookPojo.setBookId(bookEntity.getBookId());
		// return the pojo object
		return newBookPojo;
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
		
	}

	@Override
	public BookPojo updateBook(BookPojo updateBook) {
		// TODO Auto-generated method stub
		return null;
	}

}
