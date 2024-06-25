package umc.study.service.MemberService;

import umc.study.domain.Member;
import umc.study.web.dto.MemberDto.MemberRequsetDto;
import umc.study.web.dto.MemberDto.MemberResponseDto;

import java.util.List;

public interface MemberService {
    Member saveMember(MemberRequsetDto.MemberSaveRequestDto member);

    List<MemberResponseDto.MemberJoinResponseDto> getMembers();

    Member updateNickname(Long id, MemberRequsetDto.MemberUpdateRequestDto member);

    void deleteMember(Long id);
}
