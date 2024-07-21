package com.example.umc.mission.converter;

import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.enums.Gender;
import com.example.umc.mission.domain.mapping.MembersMission;
import com.example.umc.mission.web.dto.request.MemberRequestDTO;
import com.example.umc.mission.web.dto.response.MemberResponseDTO;
import com.example.umc.mission.web.dto.response.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class MemberConverter {

    public static MemberResponseDTO.MissionPreViewListDTO toMissionPreReviewListDTO(Page<MembersMission> missionList) {
        List<MemberResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MemberConverter::toMissionPreReviewDTO).toList();

        return MemberResponseDTO.MissionPreViewListDTO.builder()
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

    public static MemberResponseDTO.MissionPreViewDTO toMissionPreReviewDTO(MembersMission membersMission) {
        return MemberResponseDTO.MissionPreViewDTO.builder()
                .storeName(membersMission.getMission().getStore().getName())
                .cond(membersMission.getMission().getCond())
                .reward(membersMission.getMission().getReward())
                .status(membersMission.getStatus())
                .build();
    }


    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request){

        Gender gender=null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .preferrenceofFoodList(new ArrayList<>())
                .build();
    }
}
