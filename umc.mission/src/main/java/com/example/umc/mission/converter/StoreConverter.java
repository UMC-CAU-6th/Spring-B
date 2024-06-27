package com.example.umc.mission.converter;

import com.example.umc.mission.domain.Region;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;
import com.example.umc.mission.web.dto.response.StoreResponseDTO;

public class StoreConverter {

    public static StoreResponseDTO.addStoreResponseDTO toAddStoreResponseDTO(Store store) {
        return StoreResponseDTO.addStoreResponseDTO.builder()
                .store_id(store.getId())
                .store_name(store.getName())
                .build();
    }

    public static Store toStore(StoreRequestDTO.addStoreDTO request, Region region){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .phone(request.getPhone())
                .region(region)
                .build();

    }
}
