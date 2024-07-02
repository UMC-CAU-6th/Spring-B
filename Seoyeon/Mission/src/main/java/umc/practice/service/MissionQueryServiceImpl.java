package umc.practice.service;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.practice.domain.Member;
import umc.practice.domain.Mission;
import umc.practice.domain.Store;
import umc.practice.domain.enums.MissionStatus;
import umc.practice.domain.mapping.MemberMission;
import umc.practice.repository.MemberMissionRepository;
import umc.practice.repository.MemberRepository;
import umc.practice.repository.MissionRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class MissionQueryServiceImpl implements MissionQueryService{
    private final MissionRepository missionRepository;
    private final StoreQueryService storeQueryService;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<Mission> getMissionList(Long storeId, int page) {
        Store store=storeQueryService.findById(storeId).get();
        return missionRepository.findAllByStore(store, PageRequest.of(page,10));
    }

    @Override
    public Page<Mission> getChallengingMissionList(Long memberId, int page) {
        Member member=memberRepository.findById(memberId).get();
        List<MemberMission> memberMissionList=member.getMemberMissionList();
        List<Mission> missionList=memberMissionList.stream()
                .filter(memberMission->memberMission.getStatus() == MissionStatus.CHALLENGING)
                .map(memberMission-> {
                    return memberMission.getMission();
                }).toList();

        PageRequest pageRequest=PageRequest.of(page,10);
        int start=(int)pageRequest.getOffset();
        int end=Math.min(start+pageRequest.getPageSize(),missionList.size());
        List<Mission> missionSubList=missionList.subList(start,end);

        return new PageImpl<>(missionSubList,pageRequest,missionList.size());
    }

    @Override
    public boolean existMemberMission(Long memberId, Long missionId) {
        return memberMissionRepository.existsByMissionIdAndMemberId(missionId,memberId);
    }
}
