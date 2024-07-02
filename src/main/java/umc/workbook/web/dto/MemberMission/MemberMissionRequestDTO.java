package umc.workbook.web.dto.MemberMission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MemberMissionRequestDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMemberMissionRequestDTO {
        private Long memberId;
        private Long missionId;
        private String missionSpec;
        private Integer reward;
        private LocalDate deadLine;
    }
}
