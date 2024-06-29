package umc.practice.service;

import umc.practice.domain.Mission;
import umc.practice.web.dto.MissionRequestDto;

public interface MissionCommandService {
    public Mission addMission(MissionRequestDto.AddMissionRequestDto requestDto);
}
