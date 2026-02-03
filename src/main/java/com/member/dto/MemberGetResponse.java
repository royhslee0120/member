package com.member.dto;

import com.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberGetResponse {

    private final Long id;
    private final String name;
    private final Integer age;
    private final String mbti;

    public MemberGetResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.age = member.getAge();
        this.mbti = member.getMbti();
    }
}