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
        User user = userRepository.findByUsername(username);
        return user == null;
        }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean loginValidate(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        user.setActiveUser(true);
        userRepository.save(user);
        return user != null;
    }

    @Override
    public void logout() {
        User user = userRepository.findByActiveUserIsTrue();
        user.setActiveUser(false);
        userRepository.save(user);
    }

    @Override
    public boolean isSomeUserLoggedIn() {
        return userRepository.findByActiveUserIsTrue() != null;
    }
}
