package umc.practice.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.practice.apiPayload.code.status.ErrorStatus;
import umc.practice.validation.annotation.ValidMissionDate;
import umc.practice.web.dto.MissionRequestDto;

import java.time.LocalDate;


@RequiredArgsConstructor
@Component
public class MissionDateValidator implements ConstraintValidator<ValidMissionDate, MissionRequestDto.DateRangeDto> {

    @Override
    public void initialize(ValidMissionDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionRequestDto.DateRangeDto dateRangeDto, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate startDate = dateRangeDto.getStartDate();
        LocalDate endDate = dateRangeDto.getEndDate();
        boolean isValid=startDate.isBefore(endDate) || startDate.isEqual(endDate);
        if(!isValid){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_DATE_NOT_VALID.getMessage()).addConstraintViolation();
        }
        return isValid;
    }


}
