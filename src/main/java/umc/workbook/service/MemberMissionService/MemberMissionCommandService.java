package umc.workbook.service.MemberMissionService;

import umc.workbook.domain.entity.mapping.MemberMission;
import umc.workbook.web.dto.MemberMission.MemberMissionRequestDTO;

public interface MemberMissionCommandService {

    MemberMission createMemberMission(Long missionId, MemberMissionRequestDTO.CreateMemberMissionRequestDTO request);
}
