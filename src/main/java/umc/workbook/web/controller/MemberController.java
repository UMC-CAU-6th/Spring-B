package umc.workbook.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.apiPayload.code.status.SuccessStatus;
import umc.workbook.converter.MemberConverter;
import umc.workbook.converter.ReviewConverter;
import umc.workbook.domain.entity.Member;
import umc.workbook.domain.entity.Review;
import umc.workbook.service.MemberService.MemberCommandService;
import umc.workbook.service.MemberService.MemberQueryService;
import umc.workbook.web.dto.Member.MemberRequestDTO;
import umc.workbook.web.dto.Member.MemberResponseDTO;
import umc.workbook.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO>
    join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(SuccessStatus.Member_OK, MemberConverter.toJoinResultDTO(member));
    }

    // 특정 멤버가 작성한 리뷰 목록 조회
    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "멤버별 작성 리뷰 목록 조회", description = "특정 멤버가 작성한 리뷰 목록을 조회합니다.")
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getReviewList(
            @PathVariable(name = "memberId") Long memberId,
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size
    ) {
        Page<Review> reviewPage = memberQueryService.getReviewList(memberId, page, size);
        ReviewResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO = ReviewConverter.reviewPreviewListDTO(reviewPage);
        return ApiResponse.onSuccess(
                SuccessStatus.Review_OK,
                reviewPreviewListDTO);
    }
}

