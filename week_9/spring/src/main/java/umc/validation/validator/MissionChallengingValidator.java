package umc.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.apiPayload.code.status.ErrorStatus;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.MemberMission;
import umc.repository.MemberMissionRepository;
import umc.repository.StoreRepository;
import umc.validation.annotation.ExistStores;
import umc.validation.annotation.isChallenging;

import java.util.List;

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
        boolean isValid = memberMission.getStatus().equals(MissionStatus.CHALLENGING);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_IS_CHALLENGING.toString()).addConstraintViolation();
        }

        return false;
    }
}
