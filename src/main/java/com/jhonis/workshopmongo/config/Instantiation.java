package com.jhonis.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jhonis.workshopmongo.domain.Author;
import com.jhonis.workshopmongo.domain.Post;
import com.jhonis.workshopmongo.domain.User;
import com.jhonis.workshopmongo.repository.PostRepository;
import com.jhonis.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com", new ArrayList<Post>());
		User alex = new User(null, "Alex Green", "alex@gmail.com", new ArrayList<Post>());
		User bob = new User(null, "Bob Grey", "bob@gmail.com", new ArrayList<Post>());
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", Author.builder().name(maria.getName()).id(maria.getId()).build());
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", Author.builder().name(maria.getName()).id(maria.getId()).build());

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);
				
	}

}
