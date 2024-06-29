package umc.practice.web.dto;

import lombok.Getter;

public class StoreRequestDto {
    @Getter
    public static class AddStoreRequestDto{
        String storeName;
        String address;
        String region;
    }
}
