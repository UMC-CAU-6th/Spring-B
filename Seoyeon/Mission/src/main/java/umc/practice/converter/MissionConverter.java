package umc.practice.converter;

import umc.practice.domain.Mission;
import umc.practice.domain.enums.MissionStatus;
import umc.practice.domain.mapping.MemberMission;
import umc.practice.web.dto.MissionRequestDto;
import umc.practice.web.dto.MissionResponseDto;

public class MissionConverter {
    public static Mission toMission(MissionRequestDto.AddMissionRequestDto requestDto){
        return Mission.builder()
                .reward(requestDto.getReward())
                .minimumPrice(requestDto.getMinimumPrice())
                .startDate(requestDto.getDateRange().getStartDate())
                .endDate(requestDto.getDateRange().getEndDate())
                .build();
    }
    public static MissionResponseDto.AddMissionResponseDto toMissionResponseDto(Mission mission){
        return MissionResponseDto.AddMissionResponseDto.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
    public static MemberMission toMemberMission(){
        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();
    }
    public static MissionResponseDto.DoMemberMissionResponseDto toDoMemberMissionDto(MemberMission memberMission){
        return MissionResponseDto.DoMemberMissionResponseDto.builder()
                .missionId(memberMission.getMission().getId())
                .id(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }

}
