package umc.practice.service;

import umc.practice.domain.Review;
import umc.practice.web.dto.ReviewRequestDto;
import umc.practice.web.dto.ReviewResponseDto;

public interface ReviewCommandService {
    public Review writeReview(ReviewRequestDto.WriteReviewRequestDto request);
}
