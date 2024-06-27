package com.example.umc.mission.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
        String title;
        String content;
        String userId;


    }
}
