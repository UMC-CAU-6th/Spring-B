package umc.workbook.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.apiPayload.code.status.SuccessStatus;
import umc.workbook.converter.MissionConverter;
import umc.workbook.domain.entity.Mission;
import umc.workbook.service.MissionService.MissionCommandService;
import umc.workbook.service.MissionService.MissionQueryService;
import umc.workbook.service.ReviewService.ReviewQueryService;
import umc.workbook.web.dto.Mission.MissionRequestDTO;
import umc.workbook.web.dto.Mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/missions")
@Slf4j
public class MissionController {

    private final MissionCommandService missionCommandService;
    //private final MissionQueryService missionQueryService;
    //private final ReviewQueryService reviewQueryService;

    // 가게에 미션 추가
    @PostMapping("/")
    @Operation(summary = "미션 추가 API", description = "가게에 미션을 추가합니다.")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> createMission(
            @RequestParam Long storeId,
            @RequestBody MissionRequestDTO.CreateMissionRequestDTO request
    ) {
        Mission newMission = missionCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess(
                SuccessStatus.Mission_OK,
                MissionConverter.toCreateMissionResultDTO(newMission)
        );
    }


}
