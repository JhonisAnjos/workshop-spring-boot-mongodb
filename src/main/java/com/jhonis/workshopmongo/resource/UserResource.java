package com.jhonis.workshopmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jhonis.workshopmongo.domain.User;
import com.jhonis.workshopmongo.resource.assembler.UserAssembler;
import com.jhonis.workshopmongo.resource.model.UserModel;
import com.jhonis.workshopmongo.resource.model.input.UserInput;
import com.jhonis.workshopmongo.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@Autowired
	private UserAssembler userAssemmbler;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<UserModel> findAll() {
		List<User> entities = this.userService.findAll();
		return this.userAssemmbler.convertToModelList(entities);
	}

	@GetMapping(path = "/{id}")
	public UserModel findById(@PathVariable String id) {
		return this.userAssemmbler.converToModel(this.userService.findById(id));
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public UserModel insert(@RequestBody UserInput input) {
		User user = this.userAssemmbler.convertToDomainEntity(input);
		return this.userAssemmbler.converToModel(this.userService.insert(user));
	}
}