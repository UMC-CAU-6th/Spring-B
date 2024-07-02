package umc.workbook.converter;

import umc.workbook.domain.entity.Member;
import umc.workbook.domain.entity.mapping.MemberMission;
import umc.workbook.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.workbook.web.dto.MemberMission.MemberMissionResponseDTO;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(MemberMissionRequestDTO.CreateMemberMissionRequestDTO request, Member member){
        return MemberMission.builder()
//                .memberMissionId(request.getMissionId())
//                .build();
                .member(member)
                .build();
    }

    public static MemberMissionResponseDTO.CreateMemberMissionResultDTO toCreateMemberMissionResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.CreateMemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getMemberMissionId())
                .memberId(memberMission.getMember().getMemberId())
                .missionId(memberMission.getMission().getMissionId())
                .createAt(memberMission.getCreatdAt())
                .build();
    }
}
