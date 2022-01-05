package com.aiproject.menu.web;

import javax.servlet.http.HttpSession;

import com.aiproject.menu.dto.SessionUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final HttpSession httpSession;

    // @GetMapping("/")
    // public String index(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
    //     if (userDetails != null) {
    //         model.addAttribute("username", userDetails.getUsername());
    //     }
    //     return "index";
    // }

    @GetMapping("/")
    public String index(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null){
            model.addAttribute("userName", user.getName());
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