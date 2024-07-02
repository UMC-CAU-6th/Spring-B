package com.example.umc.mission.validation.validator;

import com.example.umc.mission.apiPayload.code.status.ErrorStatus;
import com.example.umc.mission.domain.enums.MissionStatus;
import com.example.umc.mission.service.MissionService.MissionCommandService;
import com.example.umc.mission.validation.annotation.ExistMission;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistMissionValidator implements ConstraintValidator<ExistMission, Long> {

    private final MissionCommandService missionCommandService;

    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = missionCommandService.existOfMission(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }

}
