package umc.service.Review;

import umc.domain.Review;
import umc.web.dto.Review.ReviewRequestDTO;
import umc.web.dto.Review.ReviewResponseDTO;

public interface ReviewCommandService {
    Review joinReview(ReviewRequestDTO.ReviewJoinDto request);
}
