package com.tigercavern.dooling.member.repository;

import com.tigercavern.dooling.member.entity.Follower;
import com.tigercavern.dooling.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowerRepository extends JpaRepository<Follower, Long>, FollowerRepositoryCustom {

}
