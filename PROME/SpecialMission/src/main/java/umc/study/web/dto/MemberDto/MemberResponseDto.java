package umc.study.web.dto.MemberDto;

import lombok.*;

import java.time.LocalDateTime;

public class MemberResponseDto {
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberJoinResponseDto {
        private Long memberId;
        private String name;
        private String nickname;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
