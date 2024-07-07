package umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.apiPayload.ApiResponse;
import umc.converter.MemberMissionConverter;
import umc.converter.ReviewConverter;
import umc.domain.Review;
import umc.domain.mapping.MemberMission;
import umc.service.MemberMission.MemberMissionCommandService;
import umc.service.Review.ReviewCommandService;
import umc.validation.annotation.isChallenging;
import umc.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.web.dto.MemberMission.MemberMissionResponseDTO;
import umc.web.dto.Review.ReviewRequestDTO;
import umc.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionJoinResultDTO> join(@RequestBody @Valid @isChallenging MemberMissionRequestDTO.MemberMissionJoinDto request) {
        MemberMission memberMission = memberMissionCommandService.joinMemberMission(request);
        return  ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(memberMission));
    }


}
