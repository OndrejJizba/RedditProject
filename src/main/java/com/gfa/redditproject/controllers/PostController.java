package com.gfa.redditproject.controllers;

import com.gfa.redditproject.models.Post;
import com.gfa.redditproject.services.PostService;
import com.gfa.redditproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping({"", "/"})
    public String mainPage(@RequestParam (required = false) String user, Model model){
        model.addAttribute("posts", postService.getAll());
        model.addAttribute("user", user);
        model.addAttribute("userLoggedIn", userService.isSomeUserLoggedIn());
        return "mainpage";
    }

    @GetMapping("/newpost")
    public String newPostPage(){
        return "newpost";
    }

    @PostMapping("/newpost")
    public String newPost(@RequestParam String title, @RequestParam String URL){
        postService.save(new Post(title, URL));
        return "redirect:/";
    }

    @GetMapping("/upvote/{id}")
    public String upvote(@PathVariable Long id) throws Exception {
        postService.upvote(id);
        return "redirect:/";
    }

    @GetMapping("/downvote/{id}")
    public String downvote(@PathVariable Long id) throws Exception {
        postService.downvote(id);
        return "redirect:/";
    }

    @GetMapping("/top10")
    public String getTop10ByVotes(Model model) {
        model.addAttribute("posts", postService.getTop10PostsByVotes());
        model.addAttribute("userLoggedIn", userService.isSomeUserLoggedIn());
        return "mainpage";
    }
}
