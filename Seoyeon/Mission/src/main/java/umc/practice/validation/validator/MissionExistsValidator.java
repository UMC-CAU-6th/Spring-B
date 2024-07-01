package umc.practice.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.practice.apiPayload.code.status.ErrorStatus;
import umc.practice.repository.MissionRepository;
import umc.practice.validation.annotation.ExistMission;

@Component
@RequiredArgsConstructor
public class MissionExistsValidator implements ConstraintValidator<ExistMission,Long> {
    private final MissionRepository missionRepository;
    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        boolean isValid= missionRepository.existsById(missionId);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_EXIST.getMessage()).addConstraintViolation();
        }
        return isValid;
    }
}
