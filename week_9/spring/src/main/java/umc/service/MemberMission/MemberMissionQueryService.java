package umc.service.MemberMission;

import umc.web.dto.MemberMission.MemberMissionRequestDTO;

public interface MemberMissionQueryService {
    boolean checkMemberMission(Long memberId, Long missionId);

}
