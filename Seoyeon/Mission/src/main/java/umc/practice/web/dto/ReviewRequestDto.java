package umc.practice.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.practice.validation.annotation.ExistMember;

public class ReviewRequestDto {
    @Getter
    public static class WriteReviewRequestDto {
        @NotNull
        private int stars;
        @NotBlank
        @Size(max=200)
        private String content;
        @NotNull
        @ExistMember
        private Long writerId;
        @NotNull
        private Long storeId;
    }
}
