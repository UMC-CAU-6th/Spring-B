package umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.apiPayload.ApiResponse;
import umc.converter.ReviewConverter;
import umc.domain.Review;
import umc.service.Review.ReviewCommandService;
import umc.validation.annotation.ExistMembers;
import umc.validation.annotation.ExistStores;
import umc.web.dto.Review.ReviewRequestDTO;
import umc.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.ReviewJoinResultDTO> join(@RequestBody @Valid ReviewRequestDTO.ReviewJoinDto request) {
        Review review = reviewCommandService.joinReview(request);
        return  ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }


}
