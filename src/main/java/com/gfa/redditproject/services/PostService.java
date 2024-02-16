package com.gfa.redditproject.services;

import com.gfa.redditproject.models.Post;

import java.util.List;

public interface PostService {
    void save(Post post);
    List<Post> getAll();
    void upvote(Long id) throws Exception;
    void downvote(Long id) throws Exception;
}
