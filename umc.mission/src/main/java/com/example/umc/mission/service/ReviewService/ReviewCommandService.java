package com.example.umc.mission.service.ReviewService;

import com.example.umc.mission.domain.Review;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;

public interface ReviewCommandService {

    public Review saveReview(StoreRequestDTO.postReviewDTO request);
}
