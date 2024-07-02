package umc.workbook.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.apiPayload.code.status.SuccessStatus;
import umc.workbook.converter.ReviewConverter;
import umc.workbook.domain.entity.Review;
import umc.workbook.service.ReviewService.ReviewCommandService;
import umc.workbook.web.dto.Review.ReviewRequestDTO;
import umc.workbook.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/reviews")
@Slf4j
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    // 가게에 리뷰 생성
    @PostMapping("/")
    @Operation(summary = "리뷰 생성", description = "Review를 생성합니다.")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> reviewCreate(
            @RequestParam Long memberId,
            @RequestBody ReviewRequestDTO.CreateReviewRequestDTO request
            ) {
        Review newReview = reviewCommandService.createReview(memberId, request);
        return ApiResponse.onSuccess(
                SuccessStatus.Review_OK,
                ReviewConverter.toCreateResultDTO(newReview)
        );
    }


}
