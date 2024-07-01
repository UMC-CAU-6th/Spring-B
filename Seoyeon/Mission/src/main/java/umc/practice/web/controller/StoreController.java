package umc.practice.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.practice.apiPayload.ApiResponse;
import umc.practice.converter.ReviewConverter;
import umc.practice.converter.StoreConverter;
import umc.practice.domain.Review;
import umc.practice.domain.Store;
import umc.practice.service.StoreCommandService;
import umc.practice.service.StoreQueryService;
import umc.practice.validation.annotation.ExistStore;
import umc.practice.web.dto.StoreRequestDto;
import umc.practice.web.dto.StoreResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {
    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping
    public ApiResponse<StoreResponseDto.addStoreResponseDto> addStore(@RequestBody @Valid  StoreRequestDto.AddStoreRequestDto request){
        Store store=storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toStoreResponseDto(store));
    }

    @PostMapping("/reviews")
    public ApiResponse<StoreResponseDto.WriteReviewResponseDto> writeReview(@RequestBody @Valid StoreRequestDto.WriteReviewRequestDto requestDto){
        Review review = storeCommandService.writeReview(requestDto);
        return ApiResponse.onSuccess(ReviewConverter.toWriteReviewResponseDto(review));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게에 대한 리뷰 목록 조회",description = "query string으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable입니다"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    public ApiResponse<StoreResponseDto.ReviewPreviewListDto> getReviewList(
            @ExistStore @PathVariable(name="storeId") Long storeId,
            @RequestParam(name="page") int page){
        Page<Review> reviewPage=storeQueryService.getReviewList(storeId,page);

        return ApiResponse.onSuccess(ReviewConverter.toReviewListDto(reviewPage));
    }
}
