package com.tigercavern.dooling.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tigercavern.dooling.member.dto.ListFollowerResponse;
import com.tigercavern.dooling.member.dto.QListFollowerResponse;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.tigercavern.dooling.member.entity.QFollower.follower;
import static com.tigercavern.dooling.member.entity.QMember.member;

//@RequiredArgsConstructor
public class FollowerRepositoryImpl implements FollowerRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    public FollowerRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ListFollowerResponse> findFollowers(String email) {

        return queryFactory
                .select(new QListFollowerResponse(
                                follower.followerRegistration.name,
                                follower.followerRegistration.nickName,
                                follower.followerRegistration.profilePhoto
                        ))
                .from(follower)
                .where(follower.member.email.eq(email))
                .fetch();
    }
}
