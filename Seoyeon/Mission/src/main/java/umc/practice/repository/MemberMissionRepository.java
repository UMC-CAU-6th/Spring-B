package umc.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.practice.domain.Member;
import umc.practice.domain.Mission;
import umc.practice.domain.mapping.MemberMission;
@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
    boolean existsByMissionIdAndMemberId(Long missionId, Long memberId);
    MemberMission findByMissionIdAndMemberId(Long missionId, Long memberId);
}
