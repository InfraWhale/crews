package com.tigercavern.dooling.member.dto.follower;

import com.tigercavern.dooling.member.entity.Follower;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter @Setter
public class ListFollowedResponse {
    private String name;

    private String nickName;

    private String profilePhoto;

    public ListFollowedResponse(Follower follower) {
        this.name = follower.getFollowed().getName();
        this.nickName = follower.getFollowed().getNickName();
        this.profilePhoto = Optional.ofNullable(follower.getFollowed().getProfilePhoto())
                .orElse("");
    }
}


