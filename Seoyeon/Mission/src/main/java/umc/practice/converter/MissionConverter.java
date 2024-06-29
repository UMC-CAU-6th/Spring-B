package umc.practice.converter;

import umc.practice.domain.Mission;
import umc.practice.web.dto.MissionRequestDto;
import umc.practice.web.dto.MissionResponseDto;

import java.time.LocalDate;

public class MissionConverter {
    public static Mission toMission(MissionRequestDto.AddMissionRequestDto requestDto){
        return Mission.builder()
                .reward(requestDto.getReward())
                .minimumPrice(requestDto.getMinimumPrice())
                .startDate(requestDto.getStartDate())
                .endDate(requestDto.getEndDate())
                .build();
    }
    public static MissionResponseDto.AddMissionResponseDto toMissionResponseDto(Mission mission){
        return MissionResponseDto.AddMissionResponseDto.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
