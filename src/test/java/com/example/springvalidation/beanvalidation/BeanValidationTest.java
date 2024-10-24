package com.example.springvalidation.beanvalidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanValidationTest {

    @Test
    void beanValidation() {

        // Spring과 통합하면 아래 두줄의 코드는 사용하지 않는다.
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Test 하고싶은 상황을 만들어서 검증 가능
        TestDto dto = new TestDto();
        // 1. @NotBlank 제약조건에 위반
        dto.setStringField(" ");
        // 2. @Range 제약조건에 위반
        dto.setIntegerField(10000);

        // DTO를 검증
        Set<ConstraintViolation<TestDto>> violations = validator.validate(dto);

        // 검증 결과가 예상대로 발생했는지 확인
        // 검증에 걸린 필드가 있어야 함
        assertThat(violations).isNotEmpty();
        // 2개의 제약 위반 발생
        assertThat(violations.size()).isEqualTo(2);

        // Validation에 걸린 내역을 출력
        for(ConstraintViolation<TestDto> violation : violations) {
            // 1. 아래의 결과에 Message가 있으면 Validation에 걸린것.
            // Default Message가 있기 때문에 출력됨
            // Message를 수정하고싶다면 어노테이션 속성값(message="입력")으로 설정할 수 있다.
            // 2. 결과가 비어있으면 Validation에 걸리지 않은것.
            System.out.println("violation = " + violation.getMessage());
        }

    }

}
