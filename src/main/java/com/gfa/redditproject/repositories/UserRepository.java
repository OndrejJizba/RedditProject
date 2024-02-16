package com.gfa.redditproject.repositories;

import com.gfa.redditproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUsername (String username);
}
