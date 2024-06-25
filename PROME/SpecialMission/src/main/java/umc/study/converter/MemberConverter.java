package umc.study.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.Member;
import umc.study.web.dto.MemberDto.MemberRequsetDto;
import umc.study.web.dto.MemberDto.MemberResponseDto;

@Component
public class MemberConverter {
    public static Member toMemberSaveEntity(MemberRequsetDto.MemberSaveRequestDto memberDto) {
        return Member.builder()
                .name(memberDto.getName())
                .nickname(memberDto.getNickname())
                .build();
    }

    public static MemberResponseDto.MemberJoinResponseDto toMemberSaveRequestDto(Member member) {
        return MemberResponseDto.MemberJoinResponseDto.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .nickname(member.getNickname())
                .createdAt(member.getCreatedAt())
                .updatedAt(member.getUpdatedAt())
                .build();
    }
}
