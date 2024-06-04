package umc.study.service.PostService;

import umc.study.domain.Post;
import umc.study.web.dto.PostDto.PostRequestDto;
import umc.study.web.dto.PostDto.PostResponseDto;

import java.util.List;

public interface PostService {
    Post savePost(PostRequestDto.PostSaveRequestDto post, Long memberId);

    List<PostResponseDto.PostJoinResponseDto> getPosts();

    void deletePost(Long id);

    Post updatePost(Long id, PostRequestDto.PostSaveRequestDto post);
}
