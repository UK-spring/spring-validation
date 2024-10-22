package com.example.springvalidation.groups;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ProductRequestDtoV2 {

    // 저장, 수정 @NotBlank Validation 적용
    @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
    private String name;

    // 사용하는 모든곳에서 @NotNull Validation 적용
    @NotNull
    // 저장만 @Range 반영
    @Range(min = 10, max = 10000, groups = SaveCheck.class)
    private Integer price;

    @NotNull
    @Range(min = 1, max = 999)
    private Integer count;

}
