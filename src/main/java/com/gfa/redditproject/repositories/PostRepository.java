package com.gfa.redditproject.repositories;

import com.gfa.redditproject.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
