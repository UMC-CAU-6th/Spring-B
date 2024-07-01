package umc.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.Member;
import umc.practice.domain.Mission;
import umc.practice.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
    boolean existsByMissionIdAndMemberId(Long missionId, Long memberId);
}
