package com.example.springvalidation.conflict;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ProductRequestDto {

    // 식별자는 Database에서 자동생성

    @NotBlank
    private String name;

    @NotNull
    @Range(min = 10, max = 10000)
    private Integer price;

    @NotNull
    @Range(min = 1, max = 999)
    private Integer count;

}
