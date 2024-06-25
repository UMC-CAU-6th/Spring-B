package umc.study.web.dto.PostDto;

import lombok.*;

import java.time.LocalDateTime;

public class PostResponseDto {
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostJoinResponseDto {
        private Long postId;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Long memberId;
    }
}
