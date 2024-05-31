package com.tigercavern.dooling.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

//@RequiredArgsConstructor
public class FollowerRepositoryImpl implements FollowerRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    public FollowerRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

}
