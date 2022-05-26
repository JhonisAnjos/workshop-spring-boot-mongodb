package com.jhonis.workshopmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonis.workshopmongo.domain.Post;
import com.jhonis.workshopmongo.repository.PostRepository;
import com.jhonis.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		return this.postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(""
				+ "Post de id: "+ id + " não existe!"));
	}

}
