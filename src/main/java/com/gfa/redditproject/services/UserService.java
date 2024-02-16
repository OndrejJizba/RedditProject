package com.gfa.redditproject.services;

import com.gfa.redditproject.models.User;

public interface UserService {
    boolean validatePassword (String password, String retypePassword);
    boolean validateUser (String username);
    void save (User user);
    boolean loginValidate (String username, String password);
}
