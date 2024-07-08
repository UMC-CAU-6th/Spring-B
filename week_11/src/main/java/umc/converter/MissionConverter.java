package umc.converter;

import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.Review;
import umc.domain.Store;
import umc.web.dto.Mission.MissionRequestDTO;
import umc.web.dto.Mission.MissionResponseDTO;
import umc.web.dto.Review.ReviewRequestDTO;
import umc.web.dto.Review.ReviewResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.MissionJoinResultDTO toMissionJoinResultDTO(Mission mission) {
        return MissionResponseDTO.MissionJoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionJoinDto request, Store store) {
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .store(store)
                .build();

    }

}
