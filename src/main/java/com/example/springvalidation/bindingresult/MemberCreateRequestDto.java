package com.example.springvalidation.bindingresult;

import lombok.Data;

@Data
public class MemberCreateRequestDto {
    private Long point;
    private String name;
    private Integer age;
}
