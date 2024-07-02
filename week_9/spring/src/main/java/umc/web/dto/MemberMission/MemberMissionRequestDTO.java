package umc.web.dto.MemberMission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.domain.enums.MissionStatus;
import umc.validation.annotation.ExistCategories;
import umc.validation.annotation.ExistMembers;

import java.util.List;

public class MemberMissionRequestDTO {

    @Getter
    public static class MemberMissionJoinDto{
        @NotBlank
        MissionStatus status;
        @ExistMembers
        Long memberId;
        Long missionId;
    }
}