package com.tigercavern.dooling.member.repository;

import com.tigercavern.dooling.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByEmail(String email);

    Optional<Member> findByEmail(String email);
}
