package com.example.umc.mission.converter;

import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.Review;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;
import com.example.umc.mission.web.dto.response.StoreResponseDTO;

public class ReviewConverter {

    public static StoreResponseDTO.reviewResponseDTO toReviewResponseDTO(Review review) {
        return StoreResponseDTO.reviewResponseDTO.builder()
                .review_id(review.getId())
                .store_id(review.getStore().getId())
                .member_id(review.getMember().getId())
                .build();
    }

    public static Review toReivew(StoreRequestDTO.postReviewDTO request, Store store, Member member){
        return Review.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .starPoint(request.getStarPoint())
                .store(store)
                .member(member)
                .build();
    }
}
