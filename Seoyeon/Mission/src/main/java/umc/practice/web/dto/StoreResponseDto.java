package umc.practice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class StoreResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addStoreResponseDto {
        Long storeId;
        LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WriteReviewResponseDto {
        private Long reviewId;
        private LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewPreviewListDto {
        List<ReviewPreview> reviewList;
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
    public static class ReviewPreview{
        String writerName;
        int stars;
        String content;
        LocalDateTime createdAt;
    }

}
