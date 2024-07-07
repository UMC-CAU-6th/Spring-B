package umc.service.Mission;

import umc.domain.Mission;
import umc.domain.Review;
import umc.web.dto.Mission.MissionRequestDTO;
import umc.web.dto.Review.ReviewRequestDTO;

public interface MissionCommandService {
    Mission joinMission(MissionRequestDTO.MissionJoinDto request);
}
