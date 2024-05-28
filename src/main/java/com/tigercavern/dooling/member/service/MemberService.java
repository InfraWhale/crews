package com.tigercavern.dooling.member.service;

import com.tigercavern.dooling.member.dto.UpdateMemberRequest;
import com.tigercavern.dooling.member.dto.UpdateMemberResponse;
import com.tigercavern.dooling.member.entity.Member;
import com.tigercavern.dooling.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.time.LocalDateTime.now;
import static org.springframework.util.StringUtils.hasText;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public String join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getEmail();
    }

    public UpdateMemberResponse update(String email, UpdateMemberRequest request) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("업데이트 할 회원 정보가 없습니다."));

        UpdateMemberResponse response = new UpdateMemberResponse(email);

        if(hasText(request.getPassword())) {
            member.setPassword(request.getPassword());
            response.setPassword("updated");
        }
        if(hasText(request.getNickName())) {
            member.setNickName(request.getNickName());
            response.setNickName(request.getNickName());
        }
        if(hasText(request.getName())) {
            member.setName(request.getName());
            response.setName(request.getName());
        }
        if(hasText(request.getPhoneNumber())) {
            member.setPhoneNumber(request.getPhoneNumber());
            response.setPhoneNumber(request.getPhoneNumber());
        }
        member.setUpdateDate(now());
        response.setUpdateDate(now());

        return response;
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findAllByEmail(member.getEmail());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
    }
}
