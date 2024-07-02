package com.example.umc.mission.service.MissionService;

import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.mapping.MembersMission;
import org.springframework.data.domain.Page;

public interface MissionQueryService {

    MembersMission getMembersMission(Long missionId, Long memberId);

    boolean checkMembersMission(Long missionId, Long memberId);

    Page<Mission> getMissions(Long StoreId, Integer page);
}
