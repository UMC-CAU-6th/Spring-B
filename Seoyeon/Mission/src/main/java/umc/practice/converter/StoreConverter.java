package umc.practice.converter;

import umc.practice.domain.Store;
import umc.practice.web.dto.StoreRequestDto;
import umc.practice.web.dto.StoreResponseDto;

public class StoreConverter {
    public static Store toStore(StoreRequestDto.AddStoreRequestDto requestDto) {
        return Store.builder()
                .storeName(requestDto.getStoreName())
                .address(requestDto.getAddress())
                .build();
    }
    public static StoreResponseDto.addStoreResponseDto toStoreResponseDto(Store store) {
        return StoreResponseDto.addStoreResponseDto.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
