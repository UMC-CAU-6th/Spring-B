package umc.practice.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.practice.apiPayload.ApiResponse;
import umc.practice.converter.ReviewConverter;
import umc.practice.domain.Review;
import umc.practice.service.ReviewCommandService;
import umc.practice.web.dto.ReviewRequestDto;
import umc.practice.web.dto.ReviewResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewCommandService reviewCommandService;
    @PostMapping
    public ApiResponse<ReviewResponseDto.WriteReviewResponseDto> writeReview(@RequestBody @Valid ReviewRequestDto.WriteReviewRequestDto requestDto){
        Review review = reviewCommandService.writeReview(requestDto);
        return ApiResponse.onSuccess(ReviewConverter.toWriteReviewResponseDto(review));
    }
}
