package umc.workbook.web.dto.Store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class StoreResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateStoreResultDTO {
        Long storeId;
        LocalDateTime createAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreDTO {
        Long regionId;
        Long storeId;
        String name;
        String address;

    }
}
