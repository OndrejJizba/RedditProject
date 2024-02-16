package com.gfa.redditproject.services;

import com.gfa.redditproject.models.Post;
import com.gfa.redditproject.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImp implements PostService{

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public void upvote(Long id) throws Exception {
        Optional<Post> postToUpvote = postRepository.findById(id);
        Post post = postToUpvote.orElseThrow(() -> new Exception("Post not found"));
        post.setVotes(post.getVotes() + 1);
        postRepository.save(post);
    }

    @Override
    public void downvote(Long id) throws Exception {
        Optional<Post> postToUpvote = postRepository.findById(id);
        Post post = postToUpvote.orElseThrow(() -> new Exception("Post not found"));
        if (post.getVotes() > 0) post.setVotes(post.getVotes() - 1);
        postRepository.save(post);
    }
}
