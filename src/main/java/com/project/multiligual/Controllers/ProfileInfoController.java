package com.project.multiligual.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ProfileInfoController {
    @GetMapping("/info")
    public String info(Model model){
        model.addAttribute("title", "info");
        return "profile_info";
    }
}
