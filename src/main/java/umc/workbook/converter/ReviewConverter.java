package umc.workbook.converter;

import org.springframework.data.domain.Page;
import umc.workbook.domain.entity.Review;
import umc.workbook.web.dto.Review.ReviewRequestDTO;
import umc.workbook.web.dto.Review.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateReviewRequestDTO request){
        return Review.builder()
                .review(request.getReview())
                .score(request.getScore())
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResultDTO toCreateResultDTO(Review review) {
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getReviewId())
                .createAt(review.getCreatdAt())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review){
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .memberName(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatdAt().toLocalDate())
                .review(review.getReview())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewPage){
        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewPage.stream()
                .map(ReviewConverter::reviewPreviewDTO)
                .collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewPage.isLast())
                .isFirst(reviewPage.isFirst())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewList(reviewPreviewDTOList)
                .build();
    }
}
