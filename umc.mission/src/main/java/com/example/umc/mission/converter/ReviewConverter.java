package com.example.umc.mission.converter;

import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.Review;
import com.example.umc.mission.domain.ReviewImage;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;
import com.example.umc.mission.web.dto.response.MemberResponseDTO;
import com.example.umc.mission.web.dto.response.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static MemberResponseDTO.ReviewPreViewListDTO toMemberReviewListDTO(Page<Review> reviewList) {

        List<MemberResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::toMemberReviewDTO).toList();

        return MemberResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static MemberResponseDTO.ReviewPreViewDTO toMemberReviewDTO(Review review) {
        return MemberResponseDTO.ReviewPreViewDTO.builder()
                .storeName(review.getStore().getName())
                .starPoint(review.getStarPoint())
                .content(review.getContent())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewList) {

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .starPoint(review.getStarPoint())
                .content(review.getContent())
                .build();
    }

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

    public static ReviewImage toReviewImage(String pictureUrl, Review review){
        return ReviewImage.builder()
                .review(review)
                .pictureUrl(pictureUrl)
                .build();
    }
}
