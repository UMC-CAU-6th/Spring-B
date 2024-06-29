package com.example.umc.mission.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addStoreResponseDTO {
        Long store_id;
        String store_name;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class reviewResponseDTO{
        Long store_id;
        Long member_id;
        Long review_id;
    }

}
