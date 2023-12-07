package com.bms.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
//@ToString
@Data
public class BookPojo {
	@NotNull
	int bookId;
	@NotNull
	String bookTitle;
	String bookImageUrl;
	@NotNull
	int bookCost;
	@NotNull
	String bookGenre;
	@NotNull
	AuthorPojo authorPojo;
}
