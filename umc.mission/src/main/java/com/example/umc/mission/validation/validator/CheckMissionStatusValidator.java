package com.example.umc.mission.validation.validator;

import com.example.umc.mission.apiPayload.code.status.ErrorStatus;
import com.example.umc.mission.domain.enums.MissionStatus;
import com.example.umc.mission.domain.mapping.MembersMission;
import com.example.umc.mission.repository.MembersMissionRepository;
import com.example.umc.mission.service.MissionService.MissionCommandService;
import com.example.umc.mission.service.MissionService.MissionQueryService;
import com.example.umc.mission.service.StoreService.StoreQueryService;
import com.example.umc.mission.validation.annotation.CheckMissionStatus;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CheckMissionStatusValidator implements ConstraintValidator<CheckMissionStatus, StoreRequestDTO.postChallengeDTO> {

    private final MissionQueryService missionQueryService;

    @Override
    public void initialize(CheckMissionStatus constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(StoreRequestDTO.postChallengeDTO request, ConstraintValidatorContext context) {
        boolean isExist = missionQueryService.checkMembersMission(request.getMissionId(),request.getMemberId());

        if(isExist){
            MembersMission membersMission = missionQueryService.getMembersMission(request.getMissionId(), request.getMemberId());
            boolean isValid = (membersMission.getStatus() != MissionStatus.CHALLENGING);

            if(!isValid){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_IS_CHALLENGING.toString()).addConstraintViolation();
            }

            return isValid;
        }

        return true;
    }
}
