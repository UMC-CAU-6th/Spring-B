package umc.workbook.service.MemberMissionService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.workbook.domain.entity.Member;
import umc.workbook.domain.entity.Mission;
import umc.workbook.domain.entity.Review;
import umc.workbook.domain.entity.Store;
import umc.workbook.domain.entity.mapping.MemberMission;
import umc.workbook.repository.*;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@Getter
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService{

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Optional<MemberMission> findMemberMission(Long id) {
        return memberMissionRepository.findById(id);
    }


    @Override
    public Page<MemberMission> getMemberMissionList(Long MemberId, Integer page, Integer size){

        Member member = memberRepository.findById(MemberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        return memberMissionRepository.findAllByMember(member, PageRequest.of(page, size));
    }

}
