package umc.web.dto.Store;

import lombok.Getter;
import umc.validation.annotation.ExistRegions;

public class StoreRequestDTO {

    @Getter
    public static class StoreJoinDto {
        String name;
        String address;
        @ExistRegions
        Long regionId;
    }
}
