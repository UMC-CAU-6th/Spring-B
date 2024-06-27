package com.example.umc.mission.service.StoreService;

import com.example.umc.mission.apiPayload.code.status.ErrorStatus;
import com.example.umc.mission.apiPayload.exception.handler.RegionHandler;
import com.example.umc.mission.converter.StoreConverter;
import com.example.umc.mission.domain.Region;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.repository.RegionRepository;
import com.example.umc.mission.repository.StoreRepository;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;

    private final RegionRepository regionRepository;

    public Store saveStore(StoreRequestDTO.addStoreDTO request){

        Region region = regionRepository.findByName(request.getRegionName()).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        Store newStore = StoreConverter.toStore(request, region);

        return storeRepository.save(newStore);

    }
}
