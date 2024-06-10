package com.tigercavern.dooling.member.dto.follower;

import com.querydsl.core.annotations.QueryProjection;
import com.tigercavern.dooling.member.entity.Address;
import com.tigercavern.dooling.member.entity.Follower;
import com.tigercavern.dooling.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter @Setter
public class ListFollowingResponse {
    private String name;

    private String nickName;

    private String profilePhoto;

    public ListFollowingResponse(Follower follower) {
        this.name = follower.getFollowing().getName();
        this.nickName = follower.getFollowing().getNickName();
        this.profilePhoto = Optional.ofNullable(follower.getFollowing().getProfilePhoto())
                .orElse("");
    }
}


