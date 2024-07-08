package umc.web.dto.Mission;

import lombok.Getter;
import umc.validation.annotation.ExistStores;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class MissionJoinDto {
        Integer reward;
        LocalDate deadline;
        String missionSpec;
        @ExistStores
        Long storeId;
    }
}
