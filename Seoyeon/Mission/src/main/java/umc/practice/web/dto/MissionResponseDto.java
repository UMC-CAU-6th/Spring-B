package umc.practice.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDto {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddMissionResponseDto {
        private Long missionId;
        private LocalDateTime createdAt;
    }
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DoMissionResponseDto {
        @NotNull
        private Long id;
        @NotNull
        private Long missionId;
        @NotNull
        private LocalDateTime createdAt;
    }
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionPreviewListDto {
        List<MissionPreview> missionList;
        int listSize;
        int totalPage;
        Long totalElement;
        boolean isFirst;
        boolean isLast;
    }
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionPreview{
        Long missionId;
        String storeName;
        Long reward;
        Long minimumPrice;
    }
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompleteMissionResponseDto {
        Long missionId;
        LocalDateTime updatedAt;
    }
}
