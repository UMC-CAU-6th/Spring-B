package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Post;
import umc.study.web.dto.PostDto.PostRequestDto;
import umc.study.web.dto.PostDto.PostResponseDto;

public class PostConverter {

    public static PostResponseDto.PostJoinResponseDto toPostSaveRequestDto(Post post) {
        return PostResponseDto.PostJoinResponseDto.builder()
                .postId(post.getPostId())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .memberId(post.getMember().getMemberId())
                .build();
    }

    public static Post toPostSaveEntity(PostRequestDto.PostSaveRequestDto postDto, Member member) {
        return Post.builder()
                .content(postDto.getContent())
                .member(member)
                .build();
    }


}
