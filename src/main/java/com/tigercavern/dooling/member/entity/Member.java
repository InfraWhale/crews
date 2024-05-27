package com.tigercavern.dooling.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    private String name;

    private LocalDateTime birthday;

    private String nickName;

    private String phoneNumber;

    private String address;

    private String detailAddress;

    private String zipCode;

    private String adminCheck;

    private String cancelCheck;

    private String profilePhoto;

    private String gender;

    private LocalDateTime joinDate;

    private LocalDateTime updateDate;


}
