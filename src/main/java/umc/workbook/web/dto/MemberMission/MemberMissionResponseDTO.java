package umc.workbook.web.dto.MemberMission;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMemberMissionResultDTO {
        Long memberMissionId;
        Long memberId;
        Long missionId;
        LocalDateTime createAt;
    }
}
