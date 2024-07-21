package com.example.umc.mission.service.MissionService;

import com.example.umc.mission.apiPayload.code.status.ErrorStatus;
import com.example.umc.mission.apiPayload.exception.handler.MemberHandler;
import com.example.umc.mission.apiPayload.exception.handler.MissionHandler;
import com.example.umc.mission.apiPayload.exception.handler.StoreHandler;
import com.example.umc.mission.converter.MissionConverter;
import com.example.umc.mission.converter.StoreConverter;
import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.domain.enums.MissionStatus;
import com.example.umc.mission.domain.mapping.MembersMission;
import com.example.umc.mission.repository.MemberRepository;
import com.example.umc.mission.repository.MembersMissionRepository;
import com.example.umc.mission.repository.MissionRepository;
import com.example.umc.mission.repository.StoreRepository;
import com.example.umc.mission.web.dto.request.MissionRequestDTO;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;

    private final StoreRepository storeRepository;

    private final MemberRepository memberRepository;

    private final MembersMissionRepository membersMissionRepository;

    public Mission saveMission(MissionRequestDTO.addMissionDTO request){
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission newmission = MissionConverter.toMission(request, store);

        return missionRepository.save(newmission);
    }

    public MembersMission saveChallenge(StoreRequestDTO.postChallengeDTO request){
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(()-> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        return membersMissionRepository.save(StoreConverter.toMembersMission(member,mission));
    }

    public boolean existOfMission(Long missionId){
        return missionRepository.existsById(missionId);
    }
}
