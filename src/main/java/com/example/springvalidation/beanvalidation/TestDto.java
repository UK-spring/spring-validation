package com.example.springvalidation.beanvalidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class TestDto {

    @NotBlank
    private String stringField;

//    @NotNull(message = "메세지 수정 가능")
    @NotNull
    @Range(min = 1, max = 9999)
    private Integer integerField;

}
