package umc.practice.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import umc.practice.validation.annotation.ExistMember;
import umc.practice.validation.annotation.ExistStore;

public class ReviewRequestDto {
    @Getter
    public static class WriteReviewRequestDto {
        @NotNull
        @Max(5)@Min(1)
        private int stars;
        @NotBlank
        @Size(max=200)
        private String content;
        @NotNull
        @ExistMember
        private Long writerId;
        @NotNull
        @ExistStore
        private Long storeId;
    }
}
