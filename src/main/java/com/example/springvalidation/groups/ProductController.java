package com.example.springvalidation.groups;

import com.example.springvalidation.conflict.ProductRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ProductController {

    @PostMapping("/v2/product")
    public String save(
            // 저장 속성값 설정
            @Validated(SaveCheck.class) @ModelAttribute ProductRequestDtoV2 requestDtoV2
    ) {
        log.info("생성 API가 호출 되었습니다.");
        // Validation 성공시 repository 저장로직 호출
        return "상품 생성이 완료되었습니다";
    }

    @PutMapping("/v2/product/{id}")
    public String update(
            @PathVariable Long id,
            // 수정 속성값 설정
            @Validated(UpdateCheck.class) @ModelAttribute ProductRequestDto test
    ) {
        log.info("수정 API가 호출 되었습니다.");
        // Validation 성공시 repository 수정로직 호출
        return "상품 수정이 완료되었습니다.";
    }

}
