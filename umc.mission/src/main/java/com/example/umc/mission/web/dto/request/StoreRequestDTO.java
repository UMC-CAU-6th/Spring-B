package com.example.umc.mission.web.dto.request;

import com.example.umc.mission.validation.annotation.ExistMember;
import com.example.umc.mission.validation.annotation.ExistStore;
import jakarta.validation.constraints.*;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class addStoreDTO{
        @NotBlank
        String name;
        @Size(max = 50)
        @NotNull
        String address;
        @Size(max = 15)
        @NotNull
        String phone;
        @NotNull
        String regionName;
    }

    @Getter
    public static class postReviewDTO{
        @NotBlank
        String title;
        @NotNull
        String content;
        @Min(0)
        @Max(5)
        Integer starPoint;
        @ExistMember
        Long userId;
        @ExistStore
        Long storeId;
    }
}
