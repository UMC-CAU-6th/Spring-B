package umc.practice.converter;

import org.springframework.data.domain.Page;
import umc.practice.domain.Review;
import umc.practice.web.dto.StoreRequestDto;
import umc.practice.web.dto.StoreResponseDto;

import java.util.List;

public class ReviewConverter {
    public static Review toReview(StoreRequestDto.WriteReviewRequestDto requestDto) {
        return Review.builder()
                .content(requestDto.getContent())
                .stars(requestDto.getStars())
                .build();
    }
    public static StoreResponseDto.WriteReviewResponseDto toWriteReviewResponseDto(Review review) {
        return StoreResponseDto.WriteReviewResponseDto.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
    public static StoreResponseDto.ReviewPreview toReviewPreview(Review review) {
        return StoreResponseDto.ReviewPreview.builder()
                .writerName(review.getWriter().getName())
                .stars(review.getStars())
                .reviewId(review.getId())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .build();
    }
    public static StoreResponseDto.ReviewPreviewListDto toReviewListDto(Page<Review> reviewList){
        List<StoreResponseDto.ReviewPreview> reviewDtoList=reviewList.stream()
                .map(review->{
                    return toReviewPreview(review);
                }).toList();
        return StoreResponseDto.ReviewPreviewListDto.builder()
                .reviewList(reviewDtoList)
                .isFirst(reviewList.isFirst())
                .isLast(reviewList.isLast())
                .totalPage(reviewList.getTotalPages())
                .totalElement(reviewList.getTotalElements())
                .listSize(reviewDtoList.size())
                .build();
    }
}
