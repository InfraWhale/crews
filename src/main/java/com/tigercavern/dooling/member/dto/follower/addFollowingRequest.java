package com.tigercavern.dooling.member.dto.follower;

import lombok.Getter;

@Getter
public class addFollowingRequest {
    private Long followedId;
    private Long followingId;
}
