package umc.workbook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook.domain.entity.Member;
import umc.workbook.domain.entity.Mission;
import umc.workbook.domain.entity.Store;
import umc.workbook.domain.entity.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Page<MemberMission> findAllByMember(Member member, PageRequest pageable);
}
