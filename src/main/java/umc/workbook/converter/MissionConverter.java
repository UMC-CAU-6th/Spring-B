package umc.workbook.converter;

import umc.workbook.domain.entity.Mission;
import umc.workbook.web.dto.Mission.MissionRequestDTO;
import umc.workbook.web.dto.Mission.MissionResponseDTO;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.CreateMissionRequestDTO request){
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .deadLine(request.getDeadLine())
                .reward(request.getReward())
                .build();
    }

    public static MissionResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission){
        return MissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getMissionId())
                .createdAt(mission.getCreatdAt())
                .build();
    }


}
