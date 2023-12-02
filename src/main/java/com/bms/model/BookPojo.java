package com.bms.model;

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
public class BookPojo {
	int bookId;
	String bookTitle;
	String bookImageUrl;
	int bookCost;
	String bookGenre;
	AuthorPojo authorPojo;
}
