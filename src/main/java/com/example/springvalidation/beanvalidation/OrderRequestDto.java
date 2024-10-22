package com.example.springvalidation.beanvalidation;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
@AllArgsConstructor
public class OrderRequestDto {

    @NotNull
    @Range(min = 1000)
    private Integer price;

    @NotNull
    @Range(min = 1)
    private Integer count;

}
