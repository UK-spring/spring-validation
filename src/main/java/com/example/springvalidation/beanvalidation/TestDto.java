package com.example.springvalidation.beanvalidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class TestDto {

    @NotBlank
    private String stringField;

    @NotNull
    @Range(min = 1, max = 9999)
    private Integer integerField;

}
