package com.project.multiligual.Controllers;

import com.project.multiligual.entity.Teacher;
import com.project.multiligual.entity.User;
import com.project.multiligual.repository.TeacherRepository;
import com.project.multiligual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TeacherController {


    @Autowired
    private TeacherRepository teacherRepository;


    @GetMapping("/teacher")
    public String teacher(Model model){
        Iterable<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("users", teachers);
        return "teacher";
    }
}
