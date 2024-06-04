package umc.practice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TempResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class TempTestDto{
        String testString;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class TempExceptionDto{
        Integer flag;
    }
}
