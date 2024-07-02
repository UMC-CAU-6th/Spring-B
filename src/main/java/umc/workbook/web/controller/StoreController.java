package umc.workbook.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.apiPayload.code.status.SuccessStatus;
import umc.workbook.converter.ReviewConverter;
import umc.workbook.converter.StoreConverter;
import umc.workbook.domain.entity.Review;
import umc.workbook.domain.entity.Store;
import umc.workbook.service.ReviewService.ReviewQueryService;
import umc.workbook.service.StoreService.StoreCommandService;
import umc.workbook.service.StoreService.StoreQueryService;
import umc.workbook.web.dto.Review.ReviewResponseDTO;
import umc.workbook.web.dto.Store.StoreRequestDTO;
import umc.workbook.web.dto.Store.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/stores")
@Slf4j
public class StoreController {

    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    // 특정 지역에 가게 추가
    @PostMapping("/")
    @Operation(summary = "가게 추가", description = "특정 지역에 가게를 추가합니다.")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> storeCreate(
            @RequestParam Long regionId,
            @RequestBody StoreRequestDTO.CreateStoreRequestDTO request
    ) {
        Store newStore = storeCommandService.createStore(regionId, request);
        return ApiResponse.onSuccess(
                SuccessStatus.Store_OK,
                StoreConverter.toCreateResultDTO(newStore)
        );
    }


    // 가게 리뷰 목록 조회
    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "가게 리뷰 목록 조회", description = "특정 가게의 리뷰 목록을 조회합니다.")
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getReviewList(
            //@ExistStore
            @PathVariable(name = "storeId") Long storeId,
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size
    ) {
        Page<Review> reviewPage = storeQueryService.getReviewList(storeId, page, size);
        ReviewResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO = ReviewConverter.reviewPreviewListDTO(reviewPage);
        return ApiResponse.onSuccess(
                SuccessStatus.Review_OK,
                reviewPreviewListDTO);

    }

}
