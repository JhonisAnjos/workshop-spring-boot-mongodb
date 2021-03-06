package com.jhonis.workshopmongo.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	
	private String text;
	private Date date;
	private Author author;

}
