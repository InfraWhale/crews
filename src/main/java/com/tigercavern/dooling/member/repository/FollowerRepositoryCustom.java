package com.tigercavern.dooling.member.repository;

import com.tigercavern.dooling.member.dto.ListFollowerResponse;

import java.util.List;

public interface FollowerRepositoryCustom {

    List<ListFollowerResponse> findFollowers(String email);

}
