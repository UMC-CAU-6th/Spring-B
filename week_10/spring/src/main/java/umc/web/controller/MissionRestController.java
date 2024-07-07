package umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.apiPayload.ApiResponse;
import umc.converter.MissionConverter;
import umc.converter.ReviewConverter;
import umc.domain.Mission;
import umc.domain.Review;
import umc.service.Mission.MissionCommandService;
import umc.service.Review.ReviewCommandService;
import umc.web.dto.Mission.MissionRequestDTO;
import umc.web.dto.Mission.MissionResponseDTO;
import umc.web.dto.Review.ReviewRequestDTO;
import umc.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.MissionJoinResultDTO> join(@RequestBody @Valid MissionRequestDTO.MissionJoinDto request) {
        Mission mission = missionCommandService.joinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionJoinResultDTO(mission));
    }


}
