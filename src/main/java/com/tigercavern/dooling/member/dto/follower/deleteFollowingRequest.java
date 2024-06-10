package com.tigercavern.dooling.member.dto.follower;

import lombok.Getter;

@Getter
public class deleteFollowingRequest {
    private Long followedId;
    private Long followingId;
}
