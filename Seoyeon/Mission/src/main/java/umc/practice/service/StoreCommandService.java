package umc.practice.service;

import umc.practice.domain.Region;
import umc.practice.domain.Review;
import umc.practice.domain.Store;
import umc.practice.web.dto.StoreRequestDto;

public interface StoreCommandService  {
    public Store addStore(StoreRequestDto.AddStoreRequestDto requestDto);
    public Review writeReview(StoreRequestDto.WriteReviewRequestDto request);
}
