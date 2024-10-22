package com.example.springvalidation.requestbody;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ExampleRequestDto {

    @NotBlank
    private String field1;

    @NotNull
    @Range(min = 1, max = 150)
    private Integer field2;

}
