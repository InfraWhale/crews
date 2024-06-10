package com.tigercavern.dooling.member.dto.member;

import com.tigercavern.dooling.member.entity.Address;
import com.tigercavern.dooling.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter @Setter
@AllArgsConstructor
public class FindMemberResponse {
    private String email = "";

    private String name = "";

    private String nickName = "";

    private String phoneNumber = "";

    private Address address = new Address();

    private String profilePhoto = "";

    private String gender = "";

    public FindMemberResponse() {
    }

    public FindMemberResponse(Member member) {
        this.email = member.getEmail();
        this.name = member.getName();
        this.nickName = member.getNickName();
        this.phoneNumber = member.getPhoneNumber();
        this.address = Optional.ofNullable(member.getAddress()).orElse(new Address());
        this.profilePhoto = Optional.ofNullable(member.getProfilePhoto()).orElse("");
        this.gender = Optional.ofNullable(member.getGender()).orElse("");
    }
}
