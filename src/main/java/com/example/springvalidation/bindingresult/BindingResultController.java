package com.example.springvalidation.bindingresult;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BindingResultController {

    @PostMapping("/v1/member")
    public String createMemberV1(@ModelAttribute MemberCreateRequestDto request, Model model) {
        // Model에 저장
        System.out.println("/V1/member API가 호출되었습니다.");
        model.addAttribute("point", request.getPoint());
        model.addAttribute("name", request.getName());
        model.addAttribute("age", request.getAge());

        // Thymeleaf Template Engine View Name
        return "complete";
    }

    @PostMapping("/v2/member")
    public String createMemberV2(
            // 1. @ModelAttribute 뒤에 2. BindingResult가 위치한다.
            @ModelAttribute MemberCreateRequestDto request,
            BindingResult bindingResult,
            Model model
    ) {

        System.out.println("/V2/member API가 호출되었습니다.");
        // 3. Validation 포인트 필드 검증 (null 또는 0보다 작으면 에러)
        if (request.getPoint() == null || request.getPoint() < 0) {
            // BindingResult FieldError 추가
            bindingResult.addError(
                    new FieldError("request", "point", "point 필드는 필수이며 0 이상의 값이어야 합니다.")
            );
        }

        // Validation 이름 필드 검증
        if (!StringUtils.hasText(request.getName())) {
            // BindingResult FieldError 추가
            bindingResult.addError(
                    new FieldError("request", "name", "name 필드는 필수입니다.")
            );
        }

        // Validation 나이 필드 검증 (null 또는 0보다 작으면 에러)
        if (request.getAge() == null || request.getAge() < 0) {
            // BindingResult FieldError 추가
            bindingResult.addError(
                    new FieldError("request", "age", "age 필드는 필수이며 0 이상의 값이어야 합니다.")
            );
        }

        // 만약 BindingResult에 에러가 존재한다면, 다시 입력폼으로 이동
        // if(bindingResult.hasErros()) {
        //   return "form"
        // }

        // Model에 저장
        model.addAttribute("point", request.getPoint());
        model.addAttribute("name", request.getName());
        model.addAttribute("age", request.getAge());

        return "complete";
    }

}
