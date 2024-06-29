package umc.practice.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.practice.apiPayload.ApiResponse;
import umc.practice.converter.MissionConverter;
import umc.practice.domain.Mission;
import umc.practice.service.MissionCommandService;
import umc.practice.web.dto.MissionRequestDto;
import umc.practice.web.dto.MissionResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;
    @PostMapping("/store")
    public ApiResponse<MissionResponseDto.AddMissionResponseDto> addMission(@RequestBody @Valid MissionRequestDto.AddMissionRequestDto requestDto) {
        Mission mission=missionCommandService.addMission(requestDto);
        return ApiResponse.onSuccess(MissionConverter.toMissionResponseDto(mission));
    }
}
