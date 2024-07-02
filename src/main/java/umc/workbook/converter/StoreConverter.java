package umc.workbook.converter;

import umc.workbook.domain.entity.Store;
import umc.workbook.web.dto.Store.StoreRequestDTO;
import umc.workbook.web.dto.Store.StoreResponseDTO;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.CreateStoreRequestDTO request){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    public static StoreResponseDTO.CreateStoreResultDTO toCreateResultDTO(Store store){
        return StoreResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getStoreId())
                .createAt(store.getCreatdAt())
                .build();
    }
}
