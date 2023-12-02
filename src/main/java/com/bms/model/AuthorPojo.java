package com.bms.model;

import java.util.List;

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

public class AuthorPojo {
	int authorId;
	String authorFirstName;
	String authorLastName;
	List<BookPojo> allBooksPojo;
}
