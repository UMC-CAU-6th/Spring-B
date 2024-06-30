package com.example.umc.mission.converter;

import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.web.dto.request.MissionRequestDTO;
import com.example.umc.mission.web.dto.response.MissionResponseDTO;

public class MissionConverter {

    public static MissionResponseDTO.updateMissionResponseDTO toUpdateMissionResponseDTO(Mission mission) {
        return MissionResponseDTO.updateMissionResponseDTO.builder()
                .mission_id(mission.getId())
                .status(mission.getStatus())
                .build();
    }

    public static MissionResponseDTO.addMissionResponseDTO toAddMissionResponseDTO(Mission mission) {
        return MissionResponseDTO.addMissionResponseDTO.builder()
                .mission_id(mission.getId())
                .store_id(mission.getStore().getId())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.addMissionDTO request, Store store) {
        return Mission.builder()
                .store(store)
                .name(request.getName())
                .cond(request.getCond())
                .reward(request.getReward())
                .build();
    }
}
