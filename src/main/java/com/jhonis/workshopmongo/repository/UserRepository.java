package com.jhonis.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jhonis.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
