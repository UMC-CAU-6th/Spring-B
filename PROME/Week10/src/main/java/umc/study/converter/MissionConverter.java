package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MissionResponseDTO.MissionPreviewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .updatedAt(mission.getUpdatedAt().toLocalDate())
                .build();
    }
    public static MissionResponseDTO.MissionPreviewListDTO missionPreViewListDTO(Page<Mission> missionList){

        List<MissionResponseDTO.MissionPreviewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
