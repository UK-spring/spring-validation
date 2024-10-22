package com.example.springvalidation.beanvalidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    /**
     * 1. null을 허용하지 않는다.
     * 2. 공백(” “)을 허용하지 않는다. 하나 이상의 문자를 포함해야한다.
     * 3. 빈값(””)을 허용하지 않는다.
     * 4. CharSequence 타입 허용
     *     - String은 CharSequence(Interface)의 구현체이다.
     */
    @NotBlank
    private String name;

    /**
     * 1. null을 허용하지 않는다.
     * 2. 모든 타입을 허용한다.
     */
    @NotNull
    /**
     * 1. null을 허용하지 않는다.
     * 2. 빈값(””)을 허용하지 않는다.
     * 3. CharSequence, Collection, Map, Array 허용
     */
    @Range(min = 1, max = 120)
    private Integer age;

}
