package com.example.umc.mission.converter;

import com.example.umc.mission.domain.*;
import com.example.umc.mission.domain.enums.MissionStatus;
import com.example.umc.mission.domain.mapping.MembersMission;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;
import com.example.umc.mission.web.dto.response.StoreResponseDTO;

public class StoreConverter {

    public static StoreResponseDTO.addStoreResponseDTO toAddStoreResponseDTO(Store store) {
        return StoreResponseDTO.addStoreResponseDTO.builder()
                .store_id(store.getId())
                .store_name(store.getName())
                .build();
    }

    public static Store toStore(StoreRequestDTO.addStoreDTO request, Region region){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .phone(request.getPhone())
                .region(region)
                .build();

    }

    public static MembersMission toMembersMission(Member member, Mission mission){
        return MembersMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static StoreResponseDTO.ChallengeResponseDTO toChallengeResponseDTO(MembersMission challenge) {
        return StoreResponseDTO.ChallengeResponseDTO.builder()
                .challengeId(challenge.getId())
                .missionId(challenge.getMission().getId())
                .memberId(challenge.getMember().getId())
                .build();
    }
}
