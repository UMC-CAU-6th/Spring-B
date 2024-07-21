package com.example.umc.mission.repository;

import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.mapping.MembersMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersMissionRepository extends JpaRepository<MembersMission, Long> {
    boolean existsByMissionAndMember(Mission mission, Member member);
    MembersMission findByMissionAndMember(Mission mission, Member member);
    Page<MembersMission> findAllByMember(Member member, PageRequest pageRequest);
}
