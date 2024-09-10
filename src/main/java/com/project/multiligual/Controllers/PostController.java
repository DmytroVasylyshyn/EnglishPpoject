package com.project.multiligual.Controllers;

import com.project.multiligual.entity.CommentForPost;
import com.project.multiligual.entity.Posts;
import com.project.multiligual.entity.User;
import com.project.multiligual.repository.CommentRepository;
import com.project.multiligual.repository.PostRepository;
import com.project.multiligual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;


@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/posts")
    public String posts(Model model) {
        Iterable<Posts> posts = postRepository.findAll();

        Map<Long, String> userNames = new HashMap<>();
        Map<Long, Iterable<CommentForPost>> postCommentsMap = new HashMap<>();

        for (Posts post : posts) {
            User user = userRepository.findById(post.getUserId()).orElse(null);
            if (user != null) {
                userNames.put(post.getPostid(), user.getUsername());
            }

            Iterable<CommentForPost> comments = commentRepository.findAllByPostsPostid(post.getPostid());
            postCommentsMap.put(post.getPostid(), comments);
        }

        model.addAttribute("posts", posts);
        model.addAttribute("userNames", userNames);
        model.addAttribute("postCommentsMap", postCommentsMap);

        return "posts";
    }

    // Метод для отримання імені користувача за його ідентифікатором
    public String getUsername(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return (user != null) ? user.getUsername() : "Unknown";
    }

    @PostMapping("/posts")
    public String addComment(@RequestParam String comenttext, @RequestParam Long postId, Model model) {
        Posts post = postRepository.findById(postId).orElse(null);

        if (post != null) {
            CommentForPost commentForPost = new CommentForPost(comenttext, post);
            commentRepository.save(commentForPost);
        }
        return "redirect:/posts";
    }
//@PostMapping("/posts")
//public String addComment(@RequestParam String comenttext, @RequestParam Long postId,@RequestParam Long userId,  Model model) {
//    Posts post = postRepository.findById(postId).orElse(null);
//    User user = userRepository.findById(userId).orElse(null);
//    if (post != null) {
//        CommentForPost commentForPost = new CommentForPost(comenttext, post, user);
//        commentRepository.save(commentForPost);
//    }
//    return "redirect:/posts";
//}
}
