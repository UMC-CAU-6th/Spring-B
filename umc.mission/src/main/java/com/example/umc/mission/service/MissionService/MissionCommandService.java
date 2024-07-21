package com.example.umc.mission.service.MissionService;

import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.enums.MissionStatus;
import com.example.umc.mission.domain.mapping.MembersMission;
import com.example.umc.mission.web.dto.request.MissionRequestDTO;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;

public interface MissionCommandService {

    public Mission saveMission(MissionRequestDTO.addMissionDTO request);
    
    public MembersMission saveChallenge(StoreRequestDTO.postChallengeDTO request);

    public boolean existOfMission(Long missionId);
}
