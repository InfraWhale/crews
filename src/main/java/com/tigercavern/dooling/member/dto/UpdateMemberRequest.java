package com.tigercavern.dooling.member.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UpdateMemberRequest {

    private String password;

    private String name;

    private String nickName;

    private String phoneNumber;
}
