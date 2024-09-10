package com.project.multiligual.Controllers;

import com.project.multiligual.entity.Posts;
import com.project.multiligual.entity.User;
import com.project.multiligual.repository.PostRepository;
import com.project.multiligual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;


}
