package com.jhonis.workshopmongo.resource.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jhonis.workshopmongo.domain.User;
import com.jhonis.workshopmongo.resource.model.UserModel;
import com.jhonis.workshopmongo.resource.model.input.UserInput;

@Component
public class UserAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public UserModel converToModel(User entity) {
		return this.modelMapper.map(entity, UserModel.class);
	}

	public List<UserModel> convertToModelList(List<User> entities) {
		return entities.stream().map(user -> this.converToModel(user)).collect(Collectors.toList());
	}
	
	public User convertToDomainEntity(UserInput input) {
		return this.modelMapper.map(input, User.class);
	}
	
	public void copyToDomainEntity(UserInput input, User entity) {
		this.modelMapper.map(input, entity);
		
	}

}
