package umc.practice.converter;

import org.springframework.data.domain.Page;
import umc.practice.domain.Mission;
import umc.practice.domain.enums.MissionStatus;
import umc.practice.domain.mapping.MemberMission;
import umc.practice.web.dto.MissionRequestDto;
import umc.practice.web.dto.MissionResponseDto;

import java.util.List;

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
    public static MissionResponseDto.DoMissionResponseDto toDoMemberMissionDto(MemberMission memberMission){
        return MissionResponseDto.DoMissionResponseDto.builder()
                .missionId(memberMission.getMission().getId())
                .id(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
    public static MissionResponseDto.MissionPreview toMissionPreview(Mission mission){
        return MissionResponseDto.MissionPreview.builder()
                .storeName(mission.getStore().getStoreName())
                .reward(mission.getReward())
                .minimumPrice(mission.getMinimumPrice())
                .build();
    }
    public static MissionResponseDto.MissionPreviewListDto toMissionListDto(Page<Mission> missionList){
        List<MissionResponseDto.MissionPreview> missionDtoList=missionList.stream()
                .map(mission->{
                    return toMissionPreview(mission);
                }).toList();
        return MissionResponseDto.MissionPreviewListDto.builder()
                .missionList(missionDtoList)
                .listSize(missionDtoList.size())
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalPage(missionList.getTotalPages())
                .totalElement(missionList.getTotalElements())
                .build();
    }

}
