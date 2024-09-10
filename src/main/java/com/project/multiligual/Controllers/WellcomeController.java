package com.project.multiligual.Controllers;

import com.project.multiligual.entity.Posts;
import com.project.multiligual.entity.User;
import com.project.multiligual.repository.PostRepository;
import com.project.multiligual.repository.UserRepository;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class WellcomeController {
    public String email_users;
    public long id;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String wellcome(Model model) {
        model.addAttribute("title", "welcome");
        return "wellcome";
    }

    @PostMapping("/")
    public String handleFormSubmit(@RequestParam(required = false) String email_login,
                                   @RequestParam(required = false) String password_login,
                                   @RequestParam(required = false) String username,
                                   @RequestParam(required = false) String email,
                                   @RequestParam(required = false) String userType,
                                   @RequestParam(required = false) String password,
                                   Model model) {
        if (email_login != null && password_login != null) {
            User user = userRepository.findByEmail(email_login);
            if (user != null && user.getPassword().equals(password_login)) {
                //session.setAttribute("userEmail", email_login);
                email_users = email_login;
                id = user.getUser_id();
                return "redirect:/profile"; // Перенаправлення на профіль після входу
            } else {
                model.addAttribute("error", "Invalid email or password");
                return "wellcome"; // Повернення на сторінку ласкаво просимо з повідомленням про помилку
            }
        } else if (username != null && email != null && userType != null && password != null) {
            User existingUser = userRepository.findByEmail(email);
            if (existingUser != null && existingUser.getEmail().equals(email)) {
                return "redirect:/"; // Якщо користувач з таким email вже існує, перенаправляємо на сторінку входу
            } else {
                User newUser = new User(username, email, password, userType);
                userRepository.save(newUser);
                id = newUser.getUser_id();
                email_users = email;

                return "redirect:/profile"; // Перенаправлення на профіль після реєстрації
            }
        } else {
            return "wellcome"; // Повернення на сторінку ласкаво просимо (можливо, потрібно додати логіку для інших випадків)
        }
    }

//    @GetMapping("/profile")
//    public String showProfile(Model model) {
//        User user = userRepository.findByEmail(email_users);
//        Iterable<Posts> posts = postRepository.findAllByUserId(id);
//
//        // Оновлення об'єктів посту з використанням методу Anons()
//        for (Posts post : posts) {
//            post.Anons();
//        }
//
//        model.addAttribute("user", user);
//        model.addAttribute("posts", posts); // Передача оновлених об'єктів посту до моделі
//        return "profile";
//    }



    @GetMapping("/profile")
    public String showProfile(Model model) {
        User users=userRepository.findByEmail(email_users);
        Iterable<Posts> post=postRepository.findAllByUserId(id);
        //Iterable<User> users = Collections.singleton(userRepository.findByEmail(email_users));
        model.addAttribute("lox", users);
        model.addAttribute("post",post);
        return "profile";
    }

    @PostMapping("/profile")
    public String editProfile(@RequestParam(required = false) String text_for_post,
                              @RequestParam(required = false) String title_for_post,
                              @RequestParam(required = false) String overview,
                              @RequestParam(required = false) String change_user_name,
                              @RequestParam(required = false) String change_user_email,
                              @RequestParam(required = false) String change_user_title,
                              @RequestParam(required = false) String change_user_about,
                              @RequestParam(required = false) String change_user_photo,
                              @RequestParam(required = false) String password_user_new,
                              Model model) {
        // Отримуємо ідентифікатор користувача
        // Перевіряємо, чи текст і заголовок доповіді не порожні
        if (text_for_post != null && title_for_post != null) {
            // Створюємо новий пост з текстом, заголовком та ідентифікатором користувача
            Posts newPost = new Posts(title_for_post, text_for_post, id);
            // Зберігаємо новий пост у базі даних
            postRepository.save(newPost);
            // Перенаправляємо на сторінку профілю
            return "redirect:/profile";
        } else if (overview != null) {
            long userId = (int) id; // Перевірте, чи правильно ви отримуєте id користувача
            Optional<User> optionalUser = userRepository.findById(userId);

            User user = optionalUser.get(); // Отримати об'єкт користувача з Optional
            user.setAbout_mae(overview); // Встановити новий опис для користувача
            userRepository.save(user); // Зберегти зміненого користувача
            return "redirect:/profile";
            // Обробка випадку, коли користувач з вказаним id не знайдений
        } else if (change_user_name != null && change_user_email != null && change_user_title != null && change_user_about != null) {
            long userid = (int) id;
            Optional<User> optionalUser = userRepository.findById(userid);
            User user = optionalUser.get(); // Отримати об'єкт користувача з Optional
            user.setUsername(change_user_name); // Встановити новий опис для користувача
            user.setEmail(change_user_email);
            user.setTitle(change_user_title);
            user.setAbout_mae(change_user_about);
            userRepository.save(user); // Зберегти зміненого користувача
            return "redirect:/";
        } else if (password_user_new != null) {
            long userid = (int) id;
            Optional<User> optionalUser = userRepository.findById(userid);
            User user = optionalUser.get(); // Отримати об'єкт користувача з Optional
            user.setPassword(password_user_new); // Встановити новий опис для користувача

            userRepository.save(user); // Зберегти зміненого користувача
            return "redirect:/";
        } else {

            // Якщо текст або заголовок доповіді порожні, просто перенаправляємо на сторінку профілю
            return "redirect:/profile";
        }
    }




    public String getEmail_users() {
        return email_users;
    }

    public long getId() {
        return id;
    }


}
