package com.tigercavern.dooling.member.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class UpdateMemberResponse {
    private Long id;

    private String password = "not updated";

    private String nickName = "not updated";

    private String name = "not updated";

    private String phoneNumber = "not updated";

    private LocalDateTime updateDate;

    public UpdateMemberResponse(Long id) {
        this.id = id;
    }
}
