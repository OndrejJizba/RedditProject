package com.gfa.redditproject;

import com.gfa.redditproject.models.Post;
import com.gfa.redditproject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditProjectApplication implements CommandLineRunner {

	private final PostService postService;

	@Autowired
    public RedditProjectApplication(PostService postService) {
        this.postService = postService;
    }

    public static void main(String[] args) {
		SpringApplication.run(RedditProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		postService.save(new Post("Test", "https://google.com"));
		postService.save(new Post("Test2", "https://seznam.cz"));
	}
}
