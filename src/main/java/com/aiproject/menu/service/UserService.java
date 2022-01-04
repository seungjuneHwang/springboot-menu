package com.aiproject.menu.service;

import java.util.Optional;

import com.aiproject.menu.domain.user.User;
import com.aiproject.menu.domain.user.UserRepository;
import com.aiproject.menu.domain.user.UserRole;
import com.aiproject.menu.dto.SignupRequestDto;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC"; // 관리자 권한을 확인하기 위한 토큰

    // 회원가입 처리
    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        // 평문 패스워드
        // String password = requestDto.getPassword();
        // 디비에 저장할 때 받아온 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());
        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        String email = requestDto.getEmail();
        // 사용자 ROLE 확인
        UserRole role = UserRole.USER;
        if (requestDto.isAdmin()) { // 관리자라면 관리자 토큰 확인 후 관리자 권한을 준다
            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRole.ADMIN;
        }

        User user = new User(username, password, email, role);
        userRepository.save(user); // 회원 가입
    }
}
