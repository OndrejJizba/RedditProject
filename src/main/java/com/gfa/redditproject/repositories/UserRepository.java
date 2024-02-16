package com.gfa.redditproject.repositories;

import com.gfa.redditproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
