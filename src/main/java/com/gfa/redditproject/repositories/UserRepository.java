package com.gfa.redditproject.repositories;

import com.gfa.redditproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername (String user);
    User findByUsernameAndPassword (String user, String password);
}
