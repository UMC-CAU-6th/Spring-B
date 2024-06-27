package com.example.umc.mission.web.dto.request;

import com.example.umc.mission.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;
        @Size(min = 5, max = 20)
        String address;
        @NotNull
        Integer gender;
        @NotNull
        Integer bYear;
        @NotNull
        Integer bMonth;
        @NotNull
        Integer bDay;
        @ExistCategories
        List<Long> preferCategory;
    }
}
