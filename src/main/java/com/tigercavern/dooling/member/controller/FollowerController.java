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
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class FollowerController {

    private final FollowerRepository followerRepository;
    private final MemberRepository memberRepository;

    // 특정 계정 팔로우
    @PostMapping("/api/follower/add")
    public addFollowingResponse addfollowing(@RequestBody addFollowingRequest request) {
        try {
            Member followed = memberRepository.findById(request.getFollowedId()).orElseThrow();
            Member following = memberRepository.findById(request.getFollowingId()).orElseThrow();
            Follower follower = new Follower(followed, following);

            followerRepository.save(follower);

            return new addFollowingResponse(followed.getId(), followed.getEmail(), following.getId(), followed.getEmail());
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    // 특정 계정 팔로우 취소


    // 해당 계정을 팔로잉하는 리스트 (카운트도 필요)
    @GetMapping("/api/follower/listFollowing/{id}")
    public List<ListFollowingResponse> listFollowing(@PathVariable("id") Long id) {
        try {
            Member followed = memberRepository.findById(id).orElseThrow();

            List<Follower> followers = followerRepository.findAllByFollowed(followed);
            List<ListFollowingResponse> result = followers.stream()
                    .map(ListFollowingResponse::new)
                    .collect(Collectors.toList());

            return result;
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // 해당 계정이 팔로우하는 리스트 (카운트도 필요)
    @GetMapping("/api/follower/listFollowed/{id}")
    public List<ListFollowedResponse> listFollowed(@PathVariable("id") Long id) {
        try {
            Member following = memberRepository.findById(id).orElseThrow();

            List<Follower> followers = followerRepository.findAllByFollowing(following);
            List<ListFollowedResponse> result = followers.stream()
                    .map(ListFollowedResponse::new)
                    .collect(Collectors.toList());

            return result;
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
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
}
