package umc.workbook.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.workbook.domain.entity.Mission;
import umc.workbook.domain.entity.Review;
import umc.workbook.domain.entity.Store;
import umc.workbook.domain.entity.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionQueryService {

    Optional<MemberMission> findMemberMission(Long id);
    Page<MemberMission> getMemberMissionList(Long MemberId, Integer page, Integer size);
}
