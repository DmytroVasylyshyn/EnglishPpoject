package com.project.multiligual.Controllers;

import com.project.multiligual.entity.Posts;
import com.project.multiligual.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/posts")
    public String posts(Model model){
        Iterable<Posts> posts=postRepository.findAll();
        model.addAttribute("posts",posts);
        return "posts";
    }
}
