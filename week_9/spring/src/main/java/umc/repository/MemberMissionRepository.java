package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Member;
import umc.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}