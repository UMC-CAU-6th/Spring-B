package umc.workbook.service.ReviewService;

import umc.workbook.domain.entity.Review;
import umc.workbook.web.dto.Review.ReviewRequestDTO;

public interface ReviewCommandService {

    Review createReview(Long memberId, ReviewRequestDTO.CreateReviewRequestDTO request);
}
