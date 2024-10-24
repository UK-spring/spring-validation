package com.example.springvalidation.requestbody;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestBodyController {

    @PostMapping("/example")
    public Object save(
            @Validated @RequestBody ExampleRequestDto dto,
            BindingResult bindingResult
    ) {
        log.info("RequestBody Controller 호출");

        if(bindingResult.hasErrors()) {
            log.info("validation errors={}", bindingResult);
            // Field, Object Error 모두 JSON으로 반환
            return bindingResult.getAllErrors();
        }

        // 성공 시 RequestDto 반환(의미 없음)
        return dto;
    }

}
