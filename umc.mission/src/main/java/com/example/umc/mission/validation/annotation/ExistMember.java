package com.example.umc.mission.validation.annotation;

import com.example.umc.mission.validation.validator.MemberExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import net.bytebuddy.build.RepeatedAnnotationPlugin;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMember {
    String message() default "해당하는 멤버가 존재하지 않습니다. : 리뷰 작성 불가";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
