package com.aiproject.menu.web;

import com.aiproject.menu.config.auth.LoginUser;
import com.aiproject.menu.config.auth.SessionUser;
import com.aiproject.menu.config.auth.UserDetailsImpl;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/")
//    public String index(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
    public String index(Model model, @LoginUser SessionUser user, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (user != null) {
            model.addAttribute("username", user.getName());
        } else if(userDetails != null) {
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

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin")
    public String admin(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("admin", true);
        return "admin";
    }
}