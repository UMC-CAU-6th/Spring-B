package com.example.umc.mission.service.MissionService;

import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.web.dto.request.MissionRequestDTO;

public interface MissionCommandService {

    public Mission saveMission(MissionRequestDTO.addMissionDTO request);
}
