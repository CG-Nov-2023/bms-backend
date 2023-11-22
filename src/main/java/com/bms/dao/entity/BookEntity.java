package com.bms.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
//@EqualsAndHashCode

@Entity
@Table(name = "book_details")
public class BookEntity {

	@Id
	@Column(name = "book_id")
	int bookId;
	
	@Column(name = "book_title")
	String bookTitle;
	
	@Column(name = "book_image_url")
	String bookImageUrl;
	
	@Column(name = "book_cost")
	int bookCost;
	
	@Column(name = "book_genre")
	String bookGenre;
	
	@ManyToOne
	@JoinColumn(name = "book_author_id")
	AuthorEntity authorEntity;
	
}
