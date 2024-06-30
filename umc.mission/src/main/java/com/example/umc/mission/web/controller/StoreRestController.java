package com.example.umc.mission.web.controller;

import com.example.umc.mission.apiPayload.ApiResponse;
import com.example.umc.mission.converter.MissionConverter;
import com.example.umc.mission.converter.ReviewConverter;
import com.example.umc.mission.converter.StoreConverter;
import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.Review;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.service.MissionService.MissionCommandService;
import com.example.umc.mission.service.ReviewService.ReviewCommandService;
import com.example.umc.mission.service.StoreService.StoreCommandService;
import com.example.umc.mission.web.dto.request.MissionRequestDTO;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;
import com.example.umc.mission.web.dto.response.MissionResponseDTO;
import com.example.umc.mission.web.dto.response.StoreResponseDTO;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    private final ReviewCommandService reviewCommandService;

    private final MissionCommandService missionCommandService;

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

    //3) 가게에 미션 추가하기
    @PostMapping("/mission")
    public ApiResponse<MissionResponseDTO.addMissionResponseDTO> postMission(@RequestBody @Valid MissionRequestDTO.addMissionDTO request){
        Mission mission = missionCommandService.saveMission(request);
        return ApiResponse.onSucccess(MissionConverter.toAddMissionResponseDTO(mission));
    }

    //4) 가게의 미션을 도전 중인 미션에 추가
    //storesmissin의 status 칼럼 enum 값 변경
}
