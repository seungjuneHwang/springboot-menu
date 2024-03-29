package com.aiproject.menu.web;

import com.aiproject.menu.dto.SignupRequestDto;
import com.aiproject.menu.service.MemberService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final MemberService memberService;

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

	// 로그인 에러 시 처리
    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("error", true);
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        System.out.println("관리자? " + requestDto.isAdmin());
        memberService.registerUser(requestDto);
        return "redirect:/user/login";
    }
}