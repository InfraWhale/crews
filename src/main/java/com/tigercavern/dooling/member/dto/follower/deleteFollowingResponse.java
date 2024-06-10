package com.tigercavern.dooling.member.dto.follower;

import lombok.Getter;

@Getter
public class deleteFollowingResponse {
    private Long followedId;

    private String followedEmail;

    private Long followingId;

    private String followingEmail;

    public deleteFollowingResponse(Long followedId, String followedEmail, Long followingId, String followingEmail) {
        this.followedId = followedId;
        this.followedEmail = followedEmail;
        this.followingId = followingId;
        this.followingEmail = followingEmail;
    }
}
