package com.example.umc.mission.service.MissionService;

import com.example.umc.mission.apiPayload.code.status.ErrorStatus;
import com.example.umc.mission.apiPayload.exception.handler.MissionHandler;
import com.example.umc.mission.apiPayload.exception.handler.StoreHandler;
import com.example.umc.mission.converter.MissionConverter;
import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.domain.enums.MissionStatus;
import com.example.umc.mission.repository.MissionRepository;
import com.example.umc.mission.repository.StoreRepository;
import com.example.umc.mission.web.dto.request.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;

    private final StoreRepository storeRepository;

    public Mission saveMission(MissionRequestDTO.addMissionDTO request){
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission newmission = MissionConverter.toMission(request, store);

        return missionRepository.save(newmission);
    }

    public Mission changeStatusOfMission(Long missionId){
        Mission changedmission = missionRepository.findById(missionId)
                .orElseThrow(()-> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        changedmission.changeStatusToChallenging();

        return missionRepository.save(changedmission);
    }

    public MissionStatus checkStatusOfMission(Long missionId){
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(()-> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        return mission.getStatus();
    }

    public boolean existOfMission(Long missionId){
        return missionRepository.existsById(missionId);
    }
}
