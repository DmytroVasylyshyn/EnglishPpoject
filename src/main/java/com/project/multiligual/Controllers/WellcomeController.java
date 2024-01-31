package com.project.multiligual.Controllers;

import com.project.multiligual.entity.Posts;
import com.project.multiligual.entity.User;
import com.project.multiligual.repository.PostRepository;
import com.project.multiligual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WellcomeController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String wellcome(Model model){
        model.addAttribute("title", "wellcome");
        return "wellcome";
    }

    @PostMapping("/")
    public String adduser(@RequestParam String username, @RequestParam String email,@RequestParam String userType, @RequestParam String password,  Model model){
        User user=new User(username,email,password, userType);
        userRepository.save(user);
        return "redirect:/profile";
    }
}
