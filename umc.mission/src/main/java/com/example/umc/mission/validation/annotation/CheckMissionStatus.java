package com.example.umc.mission.validation.annotation;

import com.example.umc.mission.validation.validator.CheckMissionStatusValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckMissionStatusValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckMissionStatus {

    String message() default "해당 미션은 이미 CHALLENGING 상태입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
