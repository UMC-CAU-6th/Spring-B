package umc.service.MemberMission;

import umc.domain.Mission;
import umc.domain.mapping.MemberMission;
import umc.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.web.dto.Mission.MissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission joinMemberMission(MemberMissionRequestDTO.MemberMissionJoinDto request);
}
