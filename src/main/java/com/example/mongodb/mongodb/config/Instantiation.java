package com.example.mongodb.mongodb.config;

import com.example.mongodb.mongodb.domain.Post;
import com.example.mongodb.mongodb.domain.User;
import com.example.mongodb.mongodb.dto.UserDTO;
import com.example.mongodb.mongodb.repository.PostRepository;
import com.example.mongodb.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);

        postRepository.saveAll(Arrays.asList(post1, post2));
        userRepository.saveAll(Arrays.asList(maria,alex,bob));
    }
}
