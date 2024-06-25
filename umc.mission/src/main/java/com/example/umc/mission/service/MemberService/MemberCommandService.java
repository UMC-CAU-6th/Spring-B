package com.example.umc.mission.service.MemberService;

import com.example.umc.mission.domain.Member;
import com.example.umc.mission.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    public Member joinMember(MemberRequestDTO.JoinDTO request);
}
