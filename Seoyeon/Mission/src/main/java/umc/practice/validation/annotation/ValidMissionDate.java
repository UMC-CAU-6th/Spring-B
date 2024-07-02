package umc.practice.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.practice.validation.validator.MissionDateValidator;

import java.lang.annotation.*;
import java.time.LocalDate;

@Documented
@Constraint(validatedBy = MissionDateValidator.class)
@Target({ElementType.TYPE,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMissionDate {
    String message() default "유효하지 않은 날짜입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
