package umc.workbook.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.apiPayload.code.status.SuccessStatus;
import umc.workbook.converter.MemberConverter;
import umc.workbook.domain.entity.Member;
import umc.workbook.service.MemberService.MemberCommandService;
import umc.workbook.web.dto.Member.MemberRequestDTO;
import umc.workbook.web.dto.Member.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO>
    join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(SuccessStatus.Member_OK, MemberConverter.toJoinResultDTO(member));
    }
}

