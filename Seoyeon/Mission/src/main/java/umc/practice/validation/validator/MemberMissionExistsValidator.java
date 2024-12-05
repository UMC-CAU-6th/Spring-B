package umc.practice.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.practice.apiPayload.code.status.ErrorStatus;
import umc.practice.service.MissionCommandService;
import umc.practice.service.MissionQueryService;
import umc.practice.validation.annotation.ExistsMemberMission;
import umc.practice.web.dto.MissionRequestDto;
@Component
@RequiredArgsConstructor
public class MemberMissionExistsValidator implements ConstraintValidator<ExistsMemberMission, MissionRequestDto.CompleteMemberMissionDto> {
    private final MissionQueryService missionQueryService;
    @Override
    public void initialize(ExistsMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionRequestDto.CompleteMemberMissionDto completeMemberMissionDto, ConstraintValidatorContext context) {
        boolean isValid= missionQueryService.existMemberMission(completeMemberMissionDto.getMemberId(), completeMemberMissionDto.getMissionId());
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.getMessage()).addConstraintViolation();
        }
        return isValid;
    }
}
