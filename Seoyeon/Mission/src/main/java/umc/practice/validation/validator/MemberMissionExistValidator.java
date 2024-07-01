package umc.practice.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.practice.apiPayload.code.status.ErrorStatus;
import umc.practice.service.MissionCommandService;
import umc.practice.validation.annotation.ExistsMemberMission;
import umc.practice.web.dto.MissionRequestDto;
@Component
@RequiredArgsConstructor
public class MemberMissionExistValidator implements ConstraintValidator<ExistsMemberMission, MissionRequestDto.MemberMissionDto> {
    private final MissionCommandService missionCommandService;
    @Override
    public void initialize(ExistsMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionRequestDto.MemberMissionDto memberMissionDto, ConstraintValidatorContext context) {
        boolean isValid= !missionCommandService.checkMissionChallenging(memberMissionDto.getMissionId(), memberMissionDto.getMemberId());
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_DUPLICATED.getMessage()).addConstraintViolation();
        }
        return isValid;
    }
}
