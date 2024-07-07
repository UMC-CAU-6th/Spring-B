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

    public static MemberMissionResponseDTO.MemberMissionJoinResultDTO toJoinResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.MemberMissionJoinResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .status(memberMission.getStatus())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.MemberMissionJoinDto request, Member member, Mission mission){

        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }
}