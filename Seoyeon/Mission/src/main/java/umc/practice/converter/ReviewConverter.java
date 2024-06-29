package umc.practice.converter;

import umc.practice.domain.Review;
import umc.practice.web.dto.ReviewRequestDto;
import umc.practice.web.dto.ReviewResponseDto;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDto.WriteReviewRequestDto requestDto) {
        return Review.builder()
                .content(requestDto.getContent())
                .stars(requestDto.getStars())
                .build();
    }
    public static ReviewResponseDto.WriteReviewResponseDto toWriteReviewResponseDto(Review review) {
        return ReviewResponseDto.WriteReviewResponseDto.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
