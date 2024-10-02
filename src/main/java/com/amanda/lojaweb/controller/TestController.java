package com.amanda.lojaweb.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    //@PreAuthorize("hasRole('ADMIN')")
    String test(Model model, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        model.addAttribute("username", username);
        return "index";
    }
}
