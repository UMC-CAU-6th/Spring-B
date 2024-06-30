package com.example.umc.mission.web.dto.request;

import com.example.umc.mission.validation.annotation.ExistStore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class addMissionDTO{
        @NotNull
        String name;
        @NotNull
        @Size(max = 50)
        String cond;
        @NotNull
        @Min(0)
        @Max(50)
        Integer reward;
        @ExistStore
        Long storeId;
    }
}
