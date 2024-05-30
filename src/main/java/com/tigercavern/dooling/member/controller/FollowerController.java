package com.tigercavern.dooling.member.controller;

import com.tigercavern.dooling.member.dto.*;
import com.tigercavern.dooling.member.entity.Follower;
import com.tigercavern.dooling.member.entity.Member;
import com.tigercavern.dooling.member.repository.FollowerRepository;
import com.tigercavern.dooling.member.repository.MemberRepository;
import com.tigercavern.dooling.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class FollowerController {

    private final FollowerRepository followerRepository;
    private final MemberRepository memberRepository;

    // 특정 계정 팔로우
/*    @PostMapping("/api/follower/add")
    public ResponseEntity addfollowing(@RequestBody addFollowingRequest request) {
        Optional<Member> follower = memberRepository.findById(request.getFollowerId());
        Optional<Member> following = memberRepository.findById(request.getFollowingId());
    }*/


    // 해당 계정을 팔로우하는 리스트
    @GetMapping("/api/follower/findFollowers/{email}")
    public List<ListFollowerResponse> findFollowers(@PathVariable("email") String email
    ) {
        return followerRepository.findFollowers(email);
    }
/*    @GetMapping("/api/follower/findFollowers/{email}")
    public Page<ListFollowerResponse> findFollowers(@PathVariable("email") String email,
                                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                                    @RequestParam(name = "pageSize", defaultValue = "5") int pageSize
    ) {

        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Follower> pages = followerRepository.findFollowers(pageable);
        return pages.map(ListFollowerResponse::new);
    }*/

/*    // 해당 계정이 팔로잉하는 리스트
    @GetMapping("/api/follower/findFollowings/{email}")
    public FindMemberResponse findFollowings(@PathVariable("email") String email) {

        memberService.findByEmail(email);

        return memberService.findByEmail(email);
    }*/
}
