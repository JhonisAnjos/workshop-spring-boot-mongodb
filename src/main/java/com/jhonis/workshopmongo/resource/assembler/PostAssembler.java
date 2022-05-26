package com.jhonis.workshopmongo.resource.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jhonis.workshopmongo.domain.Post;
import com.jhonis.workshopmongo.resource.model.PostModel;

@Component
public class PostAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public PostModel converToModel(Post entity) {
		return this.modelMapper.map(entity, PostModel.class);
	}

	public List<PostModel> convertToModelList(List<Post> entities) {
		return entities.stream().map(post -> this.converToModel(post)).collect(Collectors.toList());
	}
	
}
