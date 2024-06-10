package com.tigercavern.dooling.member.controller;

import com.tigercavern.dooling.member.dto.member.FindMemberResponse;
import com.tigercavern.dooling.member.dto.member.JoinMemberRequest;
import com.tigercavern.dooling.member.dto.member.UpdateMemberRequest;
import com.tigercavern.dooling.member.dto.member.UpdateMemberResponse;
import com.tigercavern.dooling.member.entity.Member;
import com.tigercavern.dooling.member.repository.MemberRepository;
import com.tigercavern.dooling.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    // 회원가입
    @PostMapping("/api/member/join")
    public ResponseEntity joinMember(@RequestBody /*@Valid*/ JoinMemberRequest request) {

        Member member = new Member(request);
        String email = memberService.join(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(email);
    }

    // 회원정보 수정
    @PostMapping("/api/member/update/{id}")
    public UpdateMemberResponse updateMember(@PathVariable("id") Long id,
                                             @RequestBody UpdateMemberRequest request) {
        return memberService.update(id, request);
    }

    // 내 정보 조회(이메일)
    @GetMapping("/api/member/findByEmail/{email}")
    public FindMemberResponse findByEmail(@PathVariable("email") String email) {

        return memberService.findByEmail(email);
    }
}
