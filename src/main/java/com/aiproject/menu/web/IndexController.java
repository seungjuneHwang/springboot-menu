package com.aiproject.menu.web;

import com.aiproject.menu.domain.user.UserDetailsImpl;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
        }
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/input")
    public String input() {
        return "input";
    }

    @GetMapping("/melon")
    public String melon() {
        return "melon";
    }

    @GetMapping("/test")
    @ResponseBody
    public String testApi() {
        return "test한글";
    }

    @GetMapping("/playlist")
    public String playlist() {
        return "playlist";
    }
}