package umc.practice.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.practice.apiPayload.ApiResponse;
import umc.practice.converter.MemberConverter;
import umc.practice.domain.Member;
import umc.practice.service.MemberCommandService;
import umc.practice.web.dto.MemberRequestDto;
import umc.practice.web.dto.MemberResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    public final MemberCommandService memberCommandService;
    @PostMapping("/sign-up")
    public ApiResponse<MemberResponseDto.signUpResponseDto> signUp(@RequestBody @Valid MemberRequestDto.signUpRequestDto request){
        Member member=memberCommandService.signUp(request);
        return ApiResponse.onSuccess(MemberConverter.toMemberResponseDto(member));
    }
}
