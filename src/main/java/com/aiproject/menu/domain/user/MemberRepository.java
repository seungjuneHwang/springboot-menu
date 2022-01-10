package com.aiproject.menu.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name); // 이름으로 사용자를 찾는다
    Optional<Member> findByEmail(String email);
}
