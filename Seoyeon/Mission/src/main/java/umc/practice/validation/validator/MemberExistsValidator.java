package umc.practice.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.practice.apiPayload.code.status.ErrorStatus;
import umc.practice.repository.MemberRepository;
import umc.practice.validation.annotation.ExistMember;

@Component
@RequiredArgsConstructor
public class MemberExistsValidator implements ConstraintValidator<ExistMember,Long> {
    private final MemberRepository memberRepository;
    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        boolean isValid= memberRepository.existsById(id);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.getMessage()).addConstraintViolation();
        }
        return isValid;
    }
}
