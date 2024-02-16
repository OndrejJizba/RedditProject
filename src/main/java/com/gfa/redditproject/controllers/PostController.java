package com.gfa.redditproject.controllers;

import com.gfa.redditproject.models.Post;
import com.gfa.redditproject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping({"", "/"})
    public String mainPage(Model model){
        model.addAttribute("posts", postService.getAll());
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
        return "mainpage";
    }
}
