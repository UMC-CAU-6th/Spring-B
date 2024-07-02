package umc.practice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.converter.MissionConverter;
import umc.practice.domain.Member;
import umc.practice.domain.Mission;
import umc.practice.domain.Store;
import umc.practice.domain.enums.MissionStatus;
import umc.practice.domain.mapping.MemberMission;
import umc.practice.repository.MemberMissionRepository;
import umc.practice.repository.MemberRepository;
import umc.practice.repository.MissionRepository;
import umc.practice.repository.StoreRepository;
import umc.practice.web.dto.MissionRequestDto;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Mission addMission(MissionRequestDto.AddMissionRequestDto requestDto) {
        Mission mission= MissionConverter.toMission(requestDto);
        Store store = storeRepository.findById(requestDto.getStoreId()).get();
        mission.setStore(store);

        return missionRepository.save(mission);
    }

    @Override
    public MemberMission doMission(MissionRequestDto.DoMissionRequestDto requestDto) {
        Member member=memberRepository.findById(requestDto.getMemberMission().getMemberId()).get();
        Mission mission=missionRepository.findById(requestDto.getMemberMission().getMissionId()).get();

        MemberMission memberMission=MissionConverter.toNewMemberMission();  //memberMission 객체 생성

        memberMission.setMember(member);    //memberMission 객체에 member 설정하기
        memberMission.setMission(mission);

//        missionRepository.save(mission);    //mission 저장(업데이트) -> memberMission 저장됨!!
//        memberRepository.save(member);      //member 저장(업데이트)
        //return memberMissionRepository.save(memberMission);
        return memberMission;
    }

    @Override
    public boolean checkMissionChallenging(Long missionId, Long memberId) {
        return memberMissionRepository.existsByMissionIdAndMemberId(missionId,memberId);
    }

    @Override
    public MemberMission completeMission(MissionRequestDto.CompleteMissionRequestDto requestDto) {
        MemberMission memberMission=memberMissionRepository.findByMissionIdAndMemberId(requestDto.getCompleteMemberMission().getMissionId(), requestDto.getCompleteMemberMission().getMemberId());
        memberMission.changeStatus(MissionStatus.COMPLETED);
        return memberMission;
    }


}
