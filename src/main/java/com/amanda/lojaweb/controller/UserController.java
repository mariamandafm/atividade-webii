package com.amanda.lojaweb.controller;

import com.amanda.lojaweb.model.UserModel;
import com.amanda.lojaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login_page";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("user", new UserModel());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserModel user){
        userService.register(user);
        return "redirect:/login?success";
    }

}
