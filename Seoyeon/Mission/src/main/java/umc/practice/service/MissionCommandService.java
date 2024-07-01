package umc.practice.service;

import umc.practice.domain.Mission;
import umc.practice.domain.mapping.MemberMission;
import umc.practice.web.dto.MissionRequestDto;

public interface MissionCommandService {
    public Mission addMission(MissionRequestDto.AddMissionRequestDto requestDto);
    public MemberMission doMission(MissionRequestDto.DoMissionRequestDto requestDto);
    public boolean checkMissionChallenging(Long missionId,Long memberId);
}
