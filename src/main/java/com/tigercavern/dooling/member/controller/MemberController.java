package com.tigercavern.dooling.member.controller;

import com.tigercavern.dooling.member.dto.FindMemberResponse;
import com.tigercavern.dooling.member.dto.JoinMemberRequest;
import com.tigercavern.dooling.member.dto.UpdateMemberRequest;
import com.tigercavern.dooling.member.dto.UpdateMemberResponse;
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

    @PostMapping("/api/member/join")
    public ResponseEntity joinMember(@RequestBody /*@Valid*/ JoinMemberRequest request) {

        Member member = new Member(request);
        String email = memberService.join(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(email);
    }

    @PostMapping("/api/member/update/{id}")
    public UpdateMemberResponse updateMember(@PathVariable("id") Long id,
                                             @RequestBody UpdateMemberRequest request) {
        return memberService.update(id, request);
    }

    @GetMapping("/api/member/findByEmail/{email}")
    public FindMemberResponse findByEmail(@PathVariable("email") String email) {

        memberService.findByEmail(email);

        return memberService.findByEmail(email);
    }
}
