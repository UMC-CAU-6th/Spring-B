package umc.practice.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import umc.practice.domain.enums.Gender;
import umc.practice.validation.annotation.ExistCategories;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class MemberRequestDto {
    @Getter
    public static class signUpRequestDto {
        @NotBlank
        String name;
        @NotNull(message = "성별은 null이면 안됩니다.")
        Gender gender;
        @NotNull(message = "생일은 null이면 안됩니다.")
        LocalDate birth;
        @Size(min=5,max=20)
        String address;
        @ExistCategories
        List<Long> favorList;
    }

}
