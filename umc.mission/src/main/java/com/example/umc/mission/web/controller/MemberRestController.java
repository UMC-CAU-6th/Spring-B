package com.example.umc.mission.web.controller;

import com.example.umc.mission.apiPayload.ApiResponse;
import com.example.umc.mission.converter.MemberConverter;
import com.example.umc.mission.converter.ReviewConverter;
import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.Review;
import com.example.umc.mission.service.MemberService.MemberCommandService;
import com.example.umc.mission.service.MemberService.MemberQueryService;
import com.example.umc.mission.validation.annotation.CheckPage;
import com.example.umc.mission.validation.annotation.ExistMember;
import com.example.umc.mission.web.dto.request.MemberRequestDTO;
import com.example.umc.mission.web.dto.response.MemberResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSucccess(MemberConverter.toJoinResultDTO(member));
    }

    //리뷰 조회
    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "특정 멤버의 리뷰 목록 조회 API", description = "특정 멤버의 리뷰목록을 조회하는 API이며, 페이징을 포함합니다. queryString올 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable")
    })
    public ApiResponse<MemberResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistMember @PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> reviews = memberQueryService.getReviewList(memberId, page-1);
        return ApiResponse.onSucccess(ReviewConverter.toMemberReviewListDTO(reviews));
    }
}
