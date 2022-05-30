package com.jhonis.workshopmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhonis.workshopmongo.domain.Post;
import com.jhonis.workshopmongo.resource.assembler.PostAssembler;
import com.jhonis.workshopmongo.resource.model.PostModel;
import com.jhonis.workshopmongo.resource.util.URL;
import com.jhonis.workshopmongo.service.PostService;

@RestController
@RequestMapping(path = "/posts")
public class PostResource {

	@Autowired
	private PostService postService;

	@Autowired
	private PostAssembler postAssembler;

	@GetMapping(path = "/{id}")
	public PostModel findById(@PathVariable String id) {
		Post post = this.postService.findById(id);
		return this.postAssembler.converToModel(post);
	}

	@GetMapping(path = "/titlesearch")
	public List<PostModel> findByTitle(@RequestParam(name = "title", defaultValue = "") String title) {
		return this.postAssembler.convertToModelList(this.postService.findByTitle(URL.decodeParam(title)));
	}
}
