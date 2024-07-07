package umc.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.apiPayload.code.status.ErrorStatus;
import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.MemberMission;
import umc.repository.MemberMissionRepository;
import umc.validation.annotation.ExistMembers;
import umc.validation.annotation.isChallenging;

@Component
@RequiredArgsConstructor
public class MissionChallengingValidator implements ConstraintValidator<isChallenging, MemberMission> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(isChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMission memberMission, ConstraintValidatorContext context) {

        Member member = memberMission.getMember();
        Mission mission = memberMission.getMission();

        MemberMission foundMemberMission = memberMissionRepository.findByMemberAndMission(member, mission);


        boolean isValid = false;

        if (foundMemberMission == memberMission) {
            isValid = true;
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_IS_CHALLENGING.toString()).addConstraintViolation();
        }

        return isValid;
    }
}