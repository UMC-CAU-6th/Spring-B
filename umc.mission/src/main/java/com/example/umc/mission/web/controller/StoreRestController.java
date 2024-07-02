package com.example.umc.mission.web.controller;

import com.example.umc.mission.apiPayload.ApiResponse;
import com.example.umc.mission.converter.MissionConverter;
import com.example.umc.mission.converter.ReviewConverter;
import com.example.umc.mission.converter.StoreConverter;
import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.Review;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.service.MissionService.MissionCommandService;
import com.example.umc.mission.service.MissionService.MissionQueryService;
import com.example.umc.mission.service.ReviewService.ReviewCommandService;
import com.example.umc.mission.service.StoreService.StoreCommandService;
import com.example.umc.mission.service.StoreService.StoreQueryService;
import com.example.umc.mission.validation.annotation.CheckMissionStatus;
import com.example.umc.mission.validation.annotation.CheckPage;
import com.example.umc.mission.validation.annotation.ExistStore;
import com.example.umc.mission.web.dto.request.MissionRequestDTO;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;
import com.example.umc.mission.web.dto.response.MissionResponseDTO;
import com.example.umc.mission.web.dto.response.StoreResponseDTO;
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
@RequestMapping("/store")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    private final ReviewCommandService reviewCommandService;

    private final MissionCommandService missionCommandService;

    private final StoreQueryService storeQueryService;

    private final MissionQueryService missionQueryService;

    //1) 특정 지역에 가게 추가하기
    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.addStoreResponseDTO> addStore(@RequestBody @Valid StoreRequestDTO.addStoreDTO request){
        Store store = storeCommandService.saveStore(request);
        return ApiResponse.onSucccess(StoreConverter.toAddStoreResponseDTO(store));
    }

    //2) 가게에 리뷰 추가하기
    @PostMapping("/review")
    public ApiResponse<StoreResponseDTO.reviewResponseDTO> postReview(@RequestBody @Valid StoreRequestDTO.postReviewDTO request){
        Review review = reviewCommandService.saveReview(request);
        return ApiResponse.onSucccess(ReviewConverter.toReviewResponseDTO(review));
    }

    //리뷰 조회
    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. queryString올 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSucccess(ReviewConverter.toReviewPreViewListDTO(reviewList));
        //return null;
    }

    //3) 가게에 미션 추가하기
    @PostMapping("/mission")
    public ApiResponse<MissionResponseDTO.addMissionResponseDTO> postMission(@RequestBody @Valid MissionRequestDTO.addMissionDTO request){
        Mission mission = missionCommandService.saveMission(request);
        return ApiResponse.onSucccess(MissionConverter.toAddMissionResponseDTO(mission));
    }

    //미션 조회
    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. queryString으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable")
    })
    public ApiResponse<StoreResponseDTO.MissionPreViewListDTO> getMissionList(@ExistStore @PathVariable(name = "storeId") Long storeId,@CheckPage @RequestParam(name = "page") Integer page){
        Page<Mission> missions = missionQueryService.getMissions(storeId, page-1);
        return ApiResponse.onSucccess(MissionConverter.toMissionPreReviewListDTO(missions));
    }

    //4) 가게의 미션을 도전 중인 미션에 추가
    @PutMapping("/{missionId}/challenge")
    public ApiResponse<MissionResponseDTO.updateMissionResponseDTO> challengeMission(@CheckMissionStatus @PathVariable(name = "missionId") Long missionId){
        Mission changedMission = missionCommandService.changeStatusOfMission(missionId);
        return ApiResponse.onSucccess(MissionConverter.toUpdateMissionResponseDTO(changedMission));
    }
}
