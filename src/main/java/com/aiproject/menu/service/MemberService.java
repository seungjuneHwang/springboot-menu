package com.aiproject.menu.service;

import java.util.Optional;

import com.aiproject.menu.domain.user.*;
import com.aiproject.menu.dto.SignupRequestDto;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String ADMIN_TOKEN = "admin"; // 관리자 권한을 확인하기 위한 토큰

    // 회원가입 처리
    public void registerUser(SignupRequestDto requestDto) {
        String name = requestDto.getName();
        // 평문 패스워드
        // String password = requestDto.getPassword();
        // 디비에 저장할 때 받아온 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());
        // 회원 ID 중복 확인
        Optional<Member> found = userRepository.findByName(name);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        String email = requestDto.getEmail();
        // 사용자 ROLE 확인
        Role role = Role.USER;
        if (requestDto.isAdmin()) { // 관리자라면 관리자 토큰 확인 후 관리자 권한을 준다
            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = Role.ADMIN;
        }

        Member user = new Member(name, password, email, role);
        userRepository.save(user); // 회원 가입
    }
}
