package umc.service.MemberMission;

import org.springframework.data.domain.Page;
import umc.domain.mapping.MemberMission;
import umc.web.dto.MemberMission.MemberMissionRequestDTO;

public interface MemberMissionQueryService {
    boolean checkMemberMission(Long memberId, Long missionId);
}
