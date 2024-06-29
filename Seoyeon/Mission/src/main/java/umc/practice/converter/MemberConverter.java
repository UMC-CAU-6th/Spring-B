package umc.practice.converter;

import umc.practice.domain.Member;
import umc.practice.web.dto.MemberRequestDto;
import umc.practice.web.dto.MemberResponseDto;

import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDto.signUpResponseDto toMemberResponseDto(Member member) {
        return MemberResponseDto.signUpResponseDto.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }
    public static Member toMember(MemberRequestDto.signUpRequestDto requestDto) {
        return Member.builder()
                .name(requestDto.getName())
                .address(requestDto.getAddress())
                .gender(requestDto.getGender())
                .birthday(requestDto.getBirth())
                .memberFoodPreferList(new ArrayList<>())
                .build();
    }

}
