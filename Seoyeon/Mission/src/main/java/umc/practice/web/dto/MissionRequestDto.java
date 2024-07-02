package umc.practice.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
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
        @NotNull
        @Valid
        @NotExistsMemberMission
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
    @Getter
    public static class CompleteMissionRequestDto{
        @NotNull
        @Valid
        @ExistsMemberMission
        CompleteMemberMissionDto completeMemberMission;
    }
    @Getter
    public static class CompleteMemberMissionDto{
        @ExistMember
        @NotNull
        Long memberId;
        @ExistMission
        @NotNull
        Long missionId;
    }
}
