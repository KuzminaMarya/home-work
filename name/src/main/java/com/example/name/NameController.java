package com.example.name;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NameController {
    @GetMapping("/user")
    public String getMessage(@RequestParam(name="name", required=false, defaultValue="Мария") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }
}
