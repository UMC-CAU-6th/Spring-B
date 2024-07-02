package umc.workbook.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.apiPayload.code.status.SuccessStatus;
import umc.workbook.converter.MemberMissionConverter;
import umc.workbook.converter.MissionConverter;
import umc.workbook.converter.ReviewConverter;
import umc.workbook.domain.entity.Mission;
import umc.workbook.domain.entity.Review;
import umc.workbook.domain.entity.mapping.MemberMission;
import umc.workbook.service.MemberMissionService.MemberMissionCommandService;
import umc.workbook.service.MemberMissionService.MemberMissionQueryService;
import umc.workbook.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.workbook.web.dto.MemberMission.MemberMissionResponseDTO;
import umc.workbook.web.dto.Mission.MissionResponseDTO;
import umc.workbook.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/member")
@Slf4j
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;

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

    // 특정 멤버가 진행중인 미션 목록 조회
    @GetMapping("/{memberId}/missions")
    @Operation(summary = "멤버별 잔행중인 미션 목록 조회", description = "특정 멤버가 진행중인 미션 목록을 조회합니다.")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreviewListDTO> getMemberMissionList(
            @PathVariable(name = "memberId") Long memberId,
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size
    ) {
        Page<MemberMission> memberMissionPage = memberMissionQueryService.getMemberMissionList(memberId, page, size);
        MemberMissionResponseDTO.MemberMissionPreviewListDTO memberMissionPreviewListDTO = MemberMissionConverter.memberMissionPreviewListDTO(memberMissionPage);
        return ApiResponse.onSuccess(
                SuccessStatus.Mission_OK,
                memberMissionPreviewListDTO);
    }
}
