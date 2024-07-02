package com.example.umc.mission.converter;

import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.Review;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.web.dto.request.MissionRequestDTO;
import com.example.umc.mission.web.dto.response.MemberResponseDTO;
import com.example.umc.mission.web.dto.response.MissionResponseDTO;
import com.example.umc.mission.web.dto.response.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class MissionConverter {

    public static StoreResponseDTO.MissionPreViewListDTO toMissionPreReviewListDTO(Page<Mission> missionList) {
        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::toMissionPreReviewDTO).toList();

        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionPreViewDTO toMissionPreReviewDTO(Mission mission) {
        return StoreResponseDTO.MissionPreViewDTO.builder()
                .storeName(mission.getStore().getName())
                .reward(mission.getReward())
                .cond(mission.getCond())
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
