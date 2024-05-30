package com.tigercavern.dooling.member.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.tigercavern.dooling.member.entity.Address;
import com.tigercavern.dooling.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter @Setter
public class ListFollowerResponse {
    private String name;

    private String nickName;

    private String profilePhoto;

/*    @QueryProjection
    public ListFollowerResponse(String name, String nickName, String profilePhoto) {
        this.name = name;
        this.nickName = nickName;
        this.profilePhoto = Optional.ofNullable(profilePhoto).orElse("");
    }*/
}


