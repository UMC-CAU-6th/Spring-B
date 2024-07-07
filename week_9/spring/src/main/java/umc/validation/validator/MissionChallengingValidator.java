package umc.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.apiPayload.code.status.ErrorStatus;
import umc.converter.MemberConverter;
import umc.converter.MemberMissionConverter;
import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.MemberMission;
import umc.repository.MemberMissionRepository;
import umc.repository.MemberRepository;
import umc.repository.MissionRepository;
import umc.validation.annotation.ExistMembers;
import umc.validation.annotation.isChallenging;
import umc.web.dto.MemberMission.MemberMissionRequestDTO;

@Component
@RequiredArgsConstructor
public class MissionChallengingValidator implements ConstraintValidator<isChallenging, MemberMissionRequestDTO.MemberMissionJoinDto> {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public void initialize(isChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO.MemberMissionJoinDto request, ConstraintValidatorContext context) {

        boolean memberValid = memberRepository.existsById(request.getMemberId());
        boolean missionValid = missionRepository.existsById(request.getMissionId());
        boolean isExist = memberValid && missionValid;

        Member member = memberRepository.findById(request.getMemberId()).orElse(null);
        Mission mission = missionRepository.findById(request.getMissionId()).orElse(null);
        MemberMission memberMission = memberMissionRepository.findByMemberAndMission(member, mission);

        if(member == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        }
        if(mission == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
        }
        if(memberMission == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_NOT_FOUND.toString()).addConstraintViolation();
        }

        if(!isExist) return false;



        MissionStatus status = memberMission.getStatus();
        

        boolean isValid = status != MissionStatus.CHALLENGING;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_IS_CHALLENGING.toString()).addConstraintViolation();
        }

        return isValid;



    }

}