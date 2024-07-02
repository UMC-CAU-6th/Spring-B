package umc.workbook.service.MissionService;

import umc.workbook.domain.entity.Mission;
import umc.workbook.web.dto.Mission.MissionRequestDTO;

public interface MissionCommandService {

    Mission createMission(Long storeId, MissionRequestDTO.CreateMissionRequestDTO request);
}
