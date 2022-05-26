package com.jhonis.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jhonis.workshopmongo.domain.Author;
import com.jhonis.workshopmongo.domain.Comment;
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
		
		Author autorMaria = Author.builder().name(maria.getName()).id(maria.getId()).build();
		Author autorrAlex = Author.builder().name(alex.getName()).id(alex.getId()).build();
		Author autorBob = Author.builder().name(bob.getName()).id(bob.getId()).build();
		
		Comment comentarioAlex_post1 = new Comment("Boa viajem mano!", sdf.parse("21/03/2018"), autorrAlex);
		Comment comentarioBob_post1 = new Comment("Aproveite", sdf.parse("21/03/2018"), autorBob);
		Comment comentarioAlex_post2 = new Comment("Tenha um ótimo dia", sdf.parse("21/03/2018"), autorrAlex);
		

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", autorMaria, Arrays.asList(comentarioAlex_post1, comentarioBob_post1));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", autorMaria, Arrays.asList(comentarioAlex_post2));

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);
				
	}

}
