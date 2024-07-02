package umc.practice.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.practice.validation.annotation.ExistsMemberMission;
import umc.practice.web.dto.MissionRequestDto;

public class MemberMissionExistsValidator implements ConstraintValidator<ExistsMemberMission, MissionRequestDto.CompleteMemberMissionDto> {

    @Override
    public void initialize(ExistsMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionRequestDto.CompleteMemberMissionDto completeMemberMissionDto, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
