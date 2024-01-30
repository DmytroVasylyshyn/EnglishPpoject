package com.project.multiligual.Controllers;

import com.project.multiligual.entity.User;
import com.project.multiligual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String showProfile(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "profile";
    }
}
