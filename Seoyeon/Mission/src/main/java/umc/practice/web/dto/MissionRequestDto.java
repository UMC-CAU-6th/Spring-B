package umc.practice.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import umc.practice.validation.annotation.*;

import java.time.LocalDate;

public class MissionRequestDto {
    @Getter
    public static class AddMissionRequestDto {
        @NotNull
        private Long reward;
        @NotNull
        private Long minimumPrice;
        @NotNull
        @ValidMissionDate
        @Valid
        private DateRangeDto dateRange;
        @NotNull
        @ExistStore
        private Long storeId;
    }

    @Getter
    public static class DateRangeDto{
        @NotNull
        @FutureOrPresent(message = "지난 날짜는 지정이 불가능합니다")
        private LocalDate startDate;
        @NotNull
        @FutureOrPresent(message = "지난 날짜는 지정이 불가능합니다")
        private LocalDate endDate;
    }
    @Getter
    public static class DoMissionRequestDto{
//        @ExistMember
//        @NotNull
//        private Long memberId;
//        @ExistMission
//        @NotNull
//        private Long missionId;
        @NotNull
        @Valid
        @ExistsMemberMission
        private MemberMissionDto memberMission;
    }
    @Getter
    public static class MemberMissionDto{
        @ExistMember
        @NotNull
        private Long memberId;
        @ExistMission
        @NotNull
        private Long missionId;
    }
}
