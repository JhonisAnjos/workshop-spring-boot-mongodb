package com.jhonis.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jhonis.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
