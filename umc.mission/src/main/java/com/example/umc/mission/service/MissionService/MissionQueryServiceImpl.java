package com.example.umc.mission.service.MissionService;

import com.example.umc.mission.apiPayload.code.status.ErrorStatus;
import com.example.umc.mission.apiPayload.exception.handler.StoreHandler;
import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.Store;
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

    @Override
    public Page<Mission> getMissions(Long StoreId, Integer page){
        Store store = storeRepository.findById(StoreId)
                .orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        return missionRepository.findAllByStore(store, PageRequest.of(page,10));
    }
}
