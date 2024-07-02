package umc.practice.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.practice.validation.validator.MemberMissionNotExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberMissionNotExistValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotExistsMemberMission {
    String message() default "미션이 이미 도전중이거나 완료하였습니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
