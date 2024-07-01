package umc.workbook.converter;

import umc.workbook.domain.entity.Review;
import umc.workbook.web.dto.Review.ReviewRequestDTO;
import umc.workbook.web.dto.Review.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateReviewRequestDTO request){
        return Review.builder()
                .review(request.getContent())
                .score(request.getScore())
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResultDTO toCreateResultDTO(Review review) {
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getReviewId())
                .createAt(review.getCreatdAt())
                .build();
    }
}
