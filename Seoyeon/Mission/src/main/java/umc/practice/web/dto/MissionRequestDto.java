package umc.practice.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDto {
    @Getter
    public static class AddMissionRequestDto {
        @NotNull
        private Long reward;
        @NotNull
        private Long minimumPrice;
        @NotNull
        private LocalDate startDate;
        @NotNull
        private LocalDate endDate;
        @NotNull
        private Long storeId;
    }
}
