package com.example.springvalidation.beanvalidation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BeanValidationController {

    @PostMapping("/error-message")
    public String beanValidation(
            @Validated @ModelAttribute TestDto dto,
            BindingResult bindingResult
    ) {

        // bindingResult Field Error 출력
        if (bindingResult.hasErrors()) {
            return String.valueOf(bindingResult.getFieldError());
        }

        // 성공시 문자열 반환
        return "회원가입 성공";
    }

    @PostMapping("/object-error")
    public String objectError(
            @Validated @ModelAttribute OrderRequestDto requestDto,
            BindingResult bindingResult
    ) {

        // 합이 10000원 이상인지 확인
        int result = requestDto.getPrice() * requestDto.getCount();
        if (result < 10000) {
            // Object Error
            bindingResult.reject("totalMin", new Object[]{10000, result}, "총 합이 10000 이상이어야 합니다.");
        }
        // Error가 있으면 출력
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return bindingResult.getAllErrors().get(0).getDefaultMessage();
        }

        // 성공로직 ...
        return "성공";
    }

}
