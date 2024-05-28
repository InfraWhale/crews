package com.tigercavern.dooling.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class UpdateMemberResponse {
    private String email;

    private String password = "not updated";

    private String nickName = "not updated";

    private String name = "not updated";

    private String phoneNumber = "not updated";

    private LocalDateTime updateDate;

    public UpdateMemberResponse(String email) {
        this.email = email;
    }
}
