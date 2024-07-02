package umc.converter;

import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.enums.Gender;
import umc.domain.mapping.MemberMission;
import umc.web.dto.Member.MemberRequestDTO;
import umc.web.dto.Member.MemberResponseDTO;
import umc.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.web.dto.MemberMission.MemberMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.MemberMissionJoinResultDTO toJoinResultDTO(Member member){
        return MemberMissionResponseDTO.MemberMissionJoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.MemberMissionJoinDto request, Member member, Mission mission){

        return MemberMission.builder()
                .status(request.getStatus())
                .member(member)
                .mission(mission)
                .build();
    }
}