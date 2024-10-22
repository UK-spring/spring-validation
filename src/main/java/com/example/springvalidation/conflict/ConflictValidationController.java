package com.example.springvalidation.conflict;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ConflictValidationController {

    @PostMapping("/product")
    public String save(
            @Validated @ModelAttribute ProductRequestDto requestDto
    ) {
        log.info("생성 API가 호출 되었습니다.");
        // Validation 성공시 repository 저장로직 호출
        return "상품 생성이 완료되었습니다";
    }

    @PutMapping("/product/{id}")
    public String update(
            @PathVariable Long id,
            @Validated @ModelAttribute ProductRequestDto test
    ) {
        log.info("수정 API가 호출 되었습니다.");
        // Validation 성공시 repository 수정로직 호출
        return "상품 수정이 완료되었습니다.";
    }

}
