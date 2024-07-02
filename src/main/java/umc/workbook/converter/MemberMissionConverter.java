package umc.workbook.converter;

import org.springframework.data.domain.Page;
import umc.workbook.domain.entity.Member;
import umc.workbook.domain.entity.Mission;
import umc.workbook.domain.entity.mapping.MemberMission;
import umc.workbook.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.workbook.web.dto.MemberMission.MemberMissionResponseDTO;
import umc.workbook.web.dto.Mission.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MemberMissionResponseDTO.MemberMissionPreviewDTO memberMissionPreviewDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.MemberMissionPreviewDTO.builder()
                .missionId(memberMission.getMission().getMissionId())
                .storeName(memberMission.getMember().getName())
                .reward(memberMission.getMission().getReward())
                .createdAt(memberMission.getCreatdAt().toLocalDate())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionPreviewListDTO memberMissionPreviewListDTO(Page<MemberMission> memberMissionPage){
        List<MemberMissionResponseDTO.MemberMissionPreviewDTO> memberMissionPreviewDTOList = memberMissionPage.stream()
                .map(MemberMissionConverter::memberMissionPreviewDTO)
                .collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionPreviewListDTO.builder()
                .isLast(memberMissionPage.isLast())
                .isFirst(memberMissionPage.isFirst())
                .totalPage(memberMissionPage.getTotalPages())
                .totalElements(memberMissionPage.getTotalElements())
                .listSize(memberMissionPreviewDTOList.size())
                .memberMissionList(memberMissionPreviewDTOList)
                .build();
    }
}
