package com.gfa.redditproject.services;

import com.gfa.redditproject.models.User;
import com.gfa.redditproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean validatePassword (String password, String retypePassword) {
        return Objects.equals(password, retypePassword);
    }

    @Override
    public boolean validateUser(String username) {
        return !username.equals(userRepository.findAllByUsername(username));
        }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
