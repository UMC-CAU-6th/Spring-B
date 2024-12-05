package umc.practice.service;

import umc.practice.domain.Member;
import umc.practice.web.dto.MemberRequestDto;

public interface MemberCommandService {
    public Member signUp(MemberRequestDto.signUpRequestDto requestDto);
}
