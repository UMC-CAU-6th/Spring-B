package umc.workbook.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.apiPayload.code.status.SuccessStatus;
import umc.workbook.converter.MemberMissionConverter;
import umc.workbook.domain.entity.mapping.MemberMission;
import umc.workbook.service.MemberMissionService.MemberMissionCommandService;
import umc.workbook.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.workbook.web.dto.MemberMission.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/member")
@Slf4j
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;

    // 수행중인 미션에 미션 추가
    @PostMapping("/missions")
    @Operation(summary = "도전 미션 목록에 미션 추가 API", description = "도전중인 미션 목록에 미션을 추가합니다.")
    public ApiResponse<MemberMissionResponseDTO.CreateMemberMissionResultDTO> createMemberMission(
            @RequestParam Long memberId,
            @RequestBody MemberMissionRequestDTO.CreateMemberMissionRequestDTO request
    ) {
        MemberMission newMemberMission = memberMissionCommandService.createMemberMission(memberId, request);
        return ApiResponse.onSuccess(
                SuccessStatus.Mission_OK,
                MemberMissionConverter.toCreateMemberMissionResultDTO(newMemberMission)
        );
    }


}
