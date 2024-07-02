package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.MemberMission;


public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>{
    Page<MemberMission> findAllByMemberId(Long memberId, PageRequest pageRequest);
}
