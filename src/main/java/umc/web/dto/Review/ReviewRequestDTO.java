package umc.web.dto.Review;

import lombok.Getter;
import umc.validation.annotation.ExistMembers;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewJoinDto {
        String body;
        Float score;
        @ExistMembers
        Long memberId;
        @ExistMembers
        Long storeId;
    }
}
