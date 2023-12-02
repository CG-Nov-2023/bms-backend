package com.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.model.AuthorPojo;
import com.bms.service.AuthorService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	//http://localhost:6868/api/authors
	@GetMapping("/authors")
	List<AuthorPojo> getAllAuthors(){
		return authorService.getAllAuthors();
	}
}
