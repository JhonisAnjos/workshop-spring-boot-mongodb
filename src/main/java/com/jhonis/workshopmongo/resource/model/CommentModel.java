package com.jhonis.workshopmongo.resource.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentModel {
	
	private String text;
	private Date date;
	private AuthorModel author;

}
