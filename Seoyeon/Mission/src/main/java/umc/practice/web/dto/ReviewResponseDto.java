package umc.practice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ReviewResponseDto {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WriteReviewResponseDto {
        private Long reviewId;
        private LocalDateTime createdAt;
    }
}
