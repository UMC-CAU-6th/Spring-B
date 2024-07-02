package umc.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook.domain.entity.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
