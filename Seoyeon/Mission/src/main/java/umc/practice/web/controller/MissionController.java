package umc.practice.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.practice.apiPayload.ApiResponse;
import umc.practice.converter.MissionConverter;
import umc.practice.domain.Mission;
import umc.practice.domain.mapping.MemberMission;
import umc.practice.service.MissionCommandService;
import umc.practice.service.MissionQueryService;
import umc.practice.validation.annotation.CheckPage;
import umc.practice.validation.annotation.ExistMember;
import umc.practice.validation.annotation.ExistStore;
import umc.practice.validation.annotation.ExistsMemberMission;
import umc.practice.web.dto.MissionRequestDto;
import umc.practice.web.dto.MissionResponseDto;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/store")
    public ApiResponse<MissionResponseDto.AddMissionResponseDto> addMission(@RequestBody @Valid MissionRequestDto.AddMissionRequestDto requestDto) {
        Mission mission=missionCommandService.addMission(requestDto);
        return ApiResponse.onSuccess(MissionConverter.toMissionResponseDto(mission));
    }

    @PostMapping("/member")
    public ApiResponse<MissionResponseDto.DoMissionResponseDto> doMission(@RequestBody @Valid MissionRequestDto.DoMissionRequestDto requestDto){
        MemberMission memberMission=missionCommandService.doMission(requestDto);
        return ApiResponse.onSuccess(MissionConverter.toDoMemberMissionDto(memberMission));
    }

    @GetMapping("/stores/{storeId}")
    @Operation(summary = "특정 가게의 미션 목록 조회 api",description = "query string으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId",description = "가게의 id, path variable입니다."),
            @Parameter(name="page",description = "페이지번호, 0번이 1페이지입니다.")
    })
    public ApiResponse<MissionResponseDto.MissionPreviewListDto> getMissionList(
            @ExistStore @PathVariable(name="storeId") Long storeId,
            @CheckPage @RequestParam(name="page") int page
    ){
        Page<Mission> missionPage=missionQueryService.getMissionList(storeId,page);
        return ApiResponse.onSuccess(MissionConverter.toMissionListDto(missionPage));
    }
    @GetMapping("/member/{memberId}")
    @Operation(summary = "특정 멤버가 진행중인 미션 목록 조회 api",description = "query string으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId",description = "사용자의 id, path variable입니다."),
            @Parameter(name="page",description = "페이지번호, 0번이 1페이지입니다.")
    })
    public ApiResponse<MissionResponseDto.MissionPreviewListDto> getChallengingMissionList(
            @ExistMember @PathVariable(name="memberId") Long memberId,
            @CheckPage @RequestParam(name="page") int page
    ){
        Page<Mission> missionPage=missionQueryService.getChallengingMissionList(memberId,page);
        return ApiResponse.onSuccess(MissionConverter.toMissionListDto(missionPage));
    }
}
