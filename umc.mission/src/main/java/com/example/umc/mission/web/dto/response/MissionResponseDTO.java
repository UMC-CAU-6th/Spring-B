package com.example.umc.mission.web.dto.response;


import com.example.umc.mission.domain.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addMissionResponseDTO {
        Long mission_id;
        Long store_id;
    }
}
