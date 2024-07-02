package umc.practice.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.practice.apiPayload.code.status.ErrorStatus;
import umc.practice.repository.RegionRepository;
import umc.practice.service.RegionQueryService;
import umc.practice.validation.annotation.ExistRegion;

@Component
@RequiredArgsConstructor
public class RegionExistValidator implements ConstraintValidator<ExistRegion, String> {
    private final RegionQueryService regionQueryService;

    @Override
    public void initialize(ExistRegion constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String regionName, ConstraintValidatorContext context) {
        boolean isValid= regionQueryService.existsByName(regionName);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_EXISTS.getMessage()).addConstraintViolation();
        }
        return isValid;
    }
}
