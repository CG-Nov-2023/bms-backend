package com.bms.dao.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "author_details")
public class AuthorEntity {

	@Id
	@Column(name = "author_id")
	int authorId;
	
	@Column(name = "author_first_name")
	String authorFirstName;
	
	@Column(name = "author_last_name")
	String authorLastName;
	
	@OneToMany(mappedBy = "authorEntity")
	List<BookEntity> allBooksEntity;
}
