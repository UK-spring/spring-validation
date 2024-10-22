package com.example.springvalidation.bindingresult;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BindingResultController {

    @PostMapping("/member")
    public String createMember(
            // 1. @ModelAttribute 뒤에 2. BindingResult가 위치한다.
            @ModelAttribute MemberCreateRequestDto request,
            BindingResult bindingResult
    ) {

        // 3. Validation (이름 필드가 있는지 검증, !없다면)
        if(!StringUtils.hasText(request.getName())) {
            // 4. bindingResult에 Error 추가
            bindingResult.addError(
                    new FieldError("request", "name", "name 필드는 필수 입니다.")
            );

        }
        return "complete";
    }

}
