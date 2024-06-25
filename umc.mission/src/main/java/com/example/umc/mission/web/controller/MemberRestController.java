package com.example.umc.mission.web.controller;

import com.example.umc.mission.apiPayload.ApiResponse;
import com.example.umc.mission.converter.MemberConverter;
import com.example.umc.mission.domain.Member;
import com.example.umc.mission.service.MemberService.MemberCommandService;
import com.example.umc.mission.web.dto.MemberRequestDTO;
import com.example.umc.mission.web.dto.MemberResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSucccess(MemberConverter.toJoinResultDTO(member));
    }
}
