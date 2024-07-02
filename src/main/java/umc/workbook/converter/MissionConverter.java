package umc.workbook.converter;

import org.springframework.data.domain.Page;
import umc.workbook.domain.entity.Mission;
import umc.workbook.domain.entity.Review;
import umc.workbook.web.dto.Mission.MissionRequestDTO;
import umc.workbook.web.dto.Mission.MissionResponseDTO;
import umc.workbook.web.dto.Review.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.MissionPreviewDTO missionPreviewDTO(Mission mission){
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .storeName(mission.getStore().getName())
                .reward(mission.getReward())
                .createdAt(mission.getCreatdAt().toLocalDate())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<Mission> missionPage){
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionPage.stream()
                .map(MissionConverter::missionPreviewDTO)
                .collect(Collectors.toList());

        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .listSize(missionPreviewDTOList.size())
                .missionList(missionPreviewDTOList)
                .build();
    }


}
