package com.example.umc.mission.web.dto.request;

import com.example.umc.mission.validation.annotation.ExistCategories;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;
        @Size(min = 5, max = 20)
        String address;
        @Min(1)
        @Max(2)
        Integer gender;
        Integer bYear;
        Integer bMonth;
        Integer bDay;
        @ExistCategories
        List<Long> preferCategory;
    }
}
