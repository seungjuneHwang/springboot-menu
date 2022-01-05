package com.aiproject.menu.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    // Optional<User> findByUsername(String name); // 이름으로 사용자를 찾는다
}
