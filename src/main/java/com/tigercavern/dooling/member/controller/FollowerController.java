package com.tigercavern.dooling.member.controller;

import com.tigercavern.dooling.member.dto.follower.*;
import com.tigercavern.dooling.member.entity.Follower;
import com.tigercavern.dooling.member.entity.Member;
import com.tigercavern.dooling.member.repository.FollowerRepository;
import com.tigercavern.dooling.member.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class FollowerController {

    private final FollowerRepository followerRepository;
    private final MemberRepository memberRepository;
    @PersistenceContext
    EntityManager em;

    // 특정 계정 팔로우
    @PostMapping("/api/follower/add")
    public addFollowingResponse addFollowing(@RequestBody addFollowingRequest request) {
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
    @DeleteMapping("/api/follower/delete")
    public String deleteFollowing(@RequestBody deleteFollowingRequest request) {
        try {
            Member followed = memberRepository.findById(request.getFollowedId()).orElseThrow();
            Member following = memberRepository.findById(request.getFollowingId()).orElseThrow();
            //Follower follower = new Follower(followed, following);
            
            // 위의 방식대로 하면 영속화 안됨 -> 영속화 되지 않은 대상은 delete() 불가
            Follower follower = followerRepository.findByFollowedAndFollowing(followed, following);
            followerRepository.delete(follower);

            int count = followerRepository.countByFollowedAndFollowing(followed, following);

            if (count == 0) {
                return "success";
            } else {
                return "fail";
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

/*    @DeleteMapping("/api/follower/delete")
    public deleteFollowingResponse deleteFollowing(@RequestBody deleteFollowingRequest request) {
        try {
            Member followed = memberRepository.findById(request.getFollowedId()).orElseThrow();
            Member following = memberRepository.findById(request.getFollowingId()).orElseThrow();
            Follower follower = new Follower(followed, following);

            followerRepository.delete(follower);

            return new deleteFollowingResponse(followed.getId(), followed.getEmail(), following.getId(), followed.getEmail());
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }*/

    // 해당 계정을 팔로잉하는 리스트
    @GetMapping("/api/follower/listFollowing/{id}")
    public Page<ListFollowingResponse> listFollowing(@PathVariable("id") Long id,
                                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                                     @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
        try {
            Pageable pageable = PageRequest.of(page, pageSize);
            Member followed = memberRepository.findById(id).orElseThrow();
            Page<Follower> followers = followerRepository.findAllByFollowed(followed, pageable);

            return followers.map(ListFollowingResponse::new);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    // 해당 계정이 팔로우하는 리스트
    @GetMapping("/api/follower/listFollowed/{id}")
    public Page<ListFollowedResponse> listFollowed(@PathVariable("id") Long id,
                                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
        try {
            Pageable pageable = PageRequest.of(page, pageSize);
            Member following = memberRepository.findById(id).orElseThrow();
            Page<Follower> followers = followerRepository.findAllByFollowing(following, pageable);

            return followers.map(ListFollowedResponse::new);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
