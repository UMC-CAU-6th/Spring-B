package umc.practice.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.practice.validation.annotation.ExistRegion;

public class StoreRequestDto {
    @Getter
    public static class AddStoreRequestDto{
        @NotBlank
        String storeName;
        @NotBlank
        String address;
        @ExistRegion
        String region;
    }
}
