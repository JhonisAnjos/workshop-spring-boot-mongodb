package com.jhonis.workshopmongo.resource.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostModel{
	
	private String id;
	
	private Date date;
	
	private String title;
	
	private String body;
	
	private AuthorModel author;
}
