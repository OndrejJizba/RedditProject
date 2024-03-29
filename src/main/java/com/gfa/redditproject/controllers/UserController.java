package com.gfa.redditproject.controllers;

import com.gfa.redditproject.models.User;
import com.gfa.redditproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String retypePassword, Model model){
        if (userService.validatePassword(password, retypePassword) && userService.validateUser(username)) {
            userService.save(new User(username, password));
            model.addAttribute("password", "Registration successful");
            return "register";
        } else if (!userService.validateUser(username)) {
            model.addAttribute("user", "User already exists.");
            return "register";
        } else if (!userService.validatePassword(password, retypePassword)) {
                model.addAttribute("password", "Passwords are not the same");
                return "register";
        } return "register";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model){
        if (userService.loginValidate(username, password)) {
            model.addAttribute("user", "Successfully logged in as " + username);
            return "mainpage";
        } else {
            model.addAttribute("user", "Wrong password or user doesn't exist.");
            return "login";
        }
    }

    @GetMapping("logout")
    public String logout(Model model){
        userService.logout();
        model.addAttribute("user", "Successfully logged out.");
        return "mainpage";
    }
}
