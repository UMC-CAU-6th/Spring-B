package umc.practice.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.practice.apiPayload.ApiResponse;
import umc.practice.converter.MissionConverter;
import umc.practice.domain.Mission;
import umc.practice.domain.mapping.MemberMission;
import umc.practice.service.MissionCommandService;
import umc.practice.validation.annotation.ExistsMemberMission;
import umc.practice.web.dto.MissionRequestDto;
import umc.practice.web.dto.MissionResponseDto;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;

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
}
