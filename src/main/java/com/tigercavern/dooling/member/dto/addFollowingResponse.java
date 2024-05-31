package com.tigercavern.dooling.member.dto;

import lombok.Getter;

@Getter
public class addFollowingResponse {
    private Long followedId;

    private String followedEmail;

    private Long followingId;

    private String followingEmail;

    public addFollowingResponse(Long followedId, String followedEmail, Long followingId, String followingEmail) {
        this.followedId = followedId;
        this.followedEmail = followedEmail;
        this.followingId = followingId;
        this.followingEmail = followingEmail;
    }
}
