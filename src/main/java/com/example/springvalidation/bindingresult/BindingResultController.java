package com.example.springvalidation.bindingresult;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

        // BindingResult의 에러 출력
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        System.out.println("allErrors = " + allErrors);

        // Model에 저장
        model.addAttribute("point", request.getPoint());
        model.addAttribute("name", request.getName());
        model.addAttribute("age", request.getAge());

        return "complete";
    }

    @PostMapping("/v3/member")
    public String createMemberV3(
            // 1. @ModelAttribute 뒤에 2. BindingResult가 위치한다.
            @ModelAttribute MemberCreateRequestDto request,
            BindingResult bindingResult,
            Model model
    ) {

        System.out.println("/V3/member API가 호출되었습니다.");

        // 3. Validation
        if (request.getAge() == null || request.getAge() < 0) {
            // BindingResult FieldError 추가
            bindingResult.addError(
                    new FieldError("request", "age", "age 필드는 필수이며 0 이상의 값이어야 합니다.")
            );
        }

        // error 처리
        if (bindingResult.hasErrors()) {
            System.out.println("Error를 처리하는 로직");
            // error 페이지 반환
            return "error";
        }

        // Model에 저장
        model.addAttribute("point", request.getPoint());
        model.addAttribute("name", request.getName());
        model.addAttribute("age", request.getAge());

        return "complete";
    }

}
