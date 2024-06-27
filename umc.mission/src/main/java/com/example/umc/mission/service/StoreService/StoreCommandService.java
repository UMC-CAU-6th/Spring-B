package com.example.umc.mission.service.StoreService;

import com.example.umc.mission.domain.Store;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;

public interface StoreCommandService {

    public Store saveStore(StoreRequestDTO.addStoreDTO request);
}
