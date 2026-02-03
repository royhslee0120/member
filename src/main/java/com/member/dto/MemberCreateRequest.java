package com.member.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreateRequest {

    @NotBlank(message = "name은 필수입니다.")
    private String name;

    @NotNull(message = "age는 필수입니다.")
    @Min(value = 0, message = "age는 0 이상이어야 합니다.")
    @Max(value = 150, message = "age는 150 이하여야 합니다.")
    private Integer age;

    @NotBlank(message = "mbti는 필수입니다.")
    private String mbti;
}