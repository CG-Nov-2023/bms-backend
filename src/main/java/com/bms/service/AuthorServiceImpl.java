package com.bms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.AuthorRepository;
import com.bms.dao.entity.AuthorEntity;
import com.bms.model.AuthorPojo;

@Service
public class AuthorServiceImpl implements AuthorService
{
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public List<AuthorPojo> getAllAuthors() {
		List<AuthorEntity> allAuthorsEntity = authorRepository.findAll();
		List<AuthorPojo> allAuthorsPojo = new ArrayList<AuthorPojo>();
		for(AuthorEntity authorEntity: allAuthorsEntity) {
			AuthorPojo authorPojo = new AuthorPojo();
			BeanUtils.copyProperties(authorEntity, authorPojo);
			allAuthorsPojo.add(authorPojo);
		}
		return allAuthorsPojo;
	}

	@Override
	public AuthorPojo getAAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthorPojo addAuthor(AuthorPojo newAuthor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAuthor(int authorId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AuthorPojo updateAuthor(AuthorPojo updateAuthor) {
		// TODO Auto-generated method stub
		return null;
	}

}
