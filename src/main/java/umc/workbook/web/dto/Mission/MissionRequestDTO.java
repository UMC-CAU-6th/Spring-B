package umc.workbook.web.dto.Mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateMissionRequestDTO {
        private Long storeId;
        private String missionSpec;
        private Integer reward;
        private LocalDate deadLine;
    }
}
