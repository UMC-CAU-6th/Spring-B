package com.example.umc.mission.validation.validator;

import com.example.umc.mission.apiPayload.code.status.ErrorStatus;
import com.example.umc.mission.domain.enums.MissionStatus;
import com.example.umc.mission.service.MissionService.MissionCommandService;
import com.example.umc.mission.validation.annotation.CheckMissionStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckMissionStatusValidator implements ConstraintValidator<CheckMissionStatus, Long> {

    private final MissionCommandService missionCommandService;

    @Override
    public void initialize(CheckMissionStatus constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isExist = missionCommandService.existOfMission(value);

        if(isExist){
            boolean isValid = (missionCommandService.checkStatusOfMission(value) != MissionStatus.CHALLENGING);

            if(!isValid){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_IS_CHALLENGING.toString()).addConstraintViolation();
            }

            return isValid;
        }
        else{
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
        }

        return false;
    }
}
