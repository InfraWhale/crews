package com.tigercavern.dooling.member.dto;

import lombok.Getter;

@Getter
public class addFollowingRequest {
    private Long followedId;
    private Long followingId;
}
