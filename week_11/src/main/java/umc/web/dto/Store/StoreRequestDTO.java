package umc.web.dto.Store;

import lombok.Getter;
import umc.validation.annotation.ExistRegions;

import java.time.LocalDate;

public class StoreRequestDTO {

    @Getter
    public static class StoreJoinDto {
        String name;
        String address;
        @ExistRegions
        Long regionId;
    }

    @Getter
    public static class ReviewDTO {
        String title;
        Float score;
        String body;
    }

    @Getter
    public static class MissionDTO {
        Integer reward;
        LocalDate deadline;
        String missionSpec;
    }
}
