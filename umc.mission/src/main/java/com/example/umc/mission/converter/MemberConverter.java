package com.example.umc.mission.converter;

import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.enums.Gender;
import com.example.umc.mission.web.dto.MemberRequestDTO;
import com.example.umc.mission.web.dto.MemberResponseDTO;

import java.util.ArrayList;

public class MemberConverter {

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
