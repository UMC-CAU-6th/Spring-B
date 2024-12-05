package umc.practice.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.practice.validation.validator.MemberMissionExistsValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberMissionExistsValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsMemberMission {
    String message() default "진행중인 미션 목록에 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
