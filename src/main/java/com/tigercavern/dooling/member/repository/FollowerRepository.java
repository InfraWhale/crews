package com.tigercavern.dooling.member.repository;

import com.tigercavern.dooling.member.entity.Follower;
import com.tigercavern.dooling.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowerRepository extends JpaRepository<Follower, Long>, FollowerRepositoryCustom {
    //List<Follower> findAllByFollowed(Member followed);

    Page<Follower> findAllByFollowed(Member followed, Pageable pageable);

    Page<Follower> findAllByFollowing(Member following, Pageable pageable);

    Follower findByFollowedAndFollowing(Member followed, Member following);
    int countByFollowedAndFollowing(Member followed, Member following);
}
