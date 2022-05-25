package com.jhonis.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonis.workshopmongo.domain.User;
import com.jhonis.workshopmongo.repository.UserRepository;
import com.jhonis.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return this.userRepository.findAll();
	}
	
	public User findById(String id) {
		return this.userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(""
				+ "Usuário de id: "+ id + " não existe!"));
	}
	
	public User insert(User user) {
		return this.userRepository.insert(user);
	}
	
	public void deleteById(String id) {
		this.findById(id);
		this.userRepository.deleteById(id);
	}
	
	public User update(User user) {
		return this.userRepository.save(user);
	}

}
