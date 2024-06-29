package umc.practice.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.practice.validation.validator.CategoriesExistValidator;
import umc.practice.validation.validator.RegionExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RegionExistValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistRegion {
    String message() default "해당하는 지역이 등록되어있지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
