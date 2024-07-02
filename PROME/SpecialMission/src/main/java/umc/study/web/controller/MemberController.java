package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.domain.Member;
import umc.study.service.MemberService.MemberService;
import umc.study.web.dto.MemberDto.MemberRequsetDto;
import umc.study.web.dto.MemberDto.MemberResponseDto;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ApiResponse<List<MemberResponseDto.MemberJoinResponseDto>> getAllMembers() {
        return ApiResponse.onSuccess(memberService.getMembers());
    }


    @PostMapping("/signup")
    public ApiResponse<MemberResponseDto.MemberJoinResponseDto> createMember(@RequestBody MemberRequsetDto.MemberSaveRequestDto member) {
        Member savedMember = memberService.saveMember(member);
        return ApiResponse.onSuccess(MemberConverter.toMemberSaveRequestDto(savedMember));
    }

    @PostMapping("/nickname/{id}")
    public ApiResponse<MemberResponseDto.MemberJoinResponseDto> updateNickname(@PathVariable Long id, @RequestBody MemberRequsetDto.MemberUpdateRequestDto member) {
        return ApiResponse.onSuccess(MemberConverter.toMemberSaveRequestDto(memberService.updateNickname(id, member)));
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ApiResponse.onSuccess("삭제 완료");
    }
}
