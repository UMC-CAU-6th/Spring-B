package com.example.umc.mission.service.MissionService;

import com.example.umc.mission.apiPayload.code.status.ErrorStatus;
import com.example.umc.mission.apiPayload.exception.handler.MemberHandler;
import com.example.umc.mission.apiPayload.exception.handler.MissionHandler;
import com.example.umc.mission.apiPayload.exception.handler.StoreHandler;
import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.domain.mapping.MembersMission;
import com.example.umc.mission.repository.MemberRepository;
import com.example.umc.mission.repository.MembersMissionRepository;
import com.example.umc.mission.repository.MissionRepository;
import com.example.umc.mission.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;

    private final StoreRepository storeRepository;

    private final MembersMissionRepository membersMissionRepository;

    private final MemberRepository memberRepository;

    @Override
    public Page<Mission> getMissions(Long StoreId, Integer page){
        Store store = storeRepository.findById(StoreId)
                .orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        return missionRepository.findAllByStore(store, PageRequest.of(page,10));
    }


    @Override
    public boolean checkMembersMission(Long missionId, Long memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(()->new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        return membersMissionRepository.existsByMissionAndMember(mission, member);
    }

    @Override
    public MembersMission getMembersMission(Long missionId, Long memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(()->new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        return membersMissionRepository.findByMissionAndMember(mission, member);
    }

}
