package umc.web.dto.MemberMission;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.domain.enums.MissionStatus;
import umc.validation.annotation.isChallenging;

public class MemberMissionRequestDTO {

    @Getter
    public static class MemberMissionJoinDto{
        Long memberId;
        Long missionId;
        MissionStatus status;
    }
}