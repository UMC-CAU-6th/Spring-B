package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.PostConverter;
import umc.study.domain.Post;
import umc.study.service.PostService.PostService;
import umc.study.web.dto.PostDto.PostRequestDto;
import umc.study.web.dto.PostDto.PostResponseDto;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ApiResponse<List<PostResponseDto.PostJoinResponseDto>> getAllPosts() {
        return ApiResponse.onSuccess(postService.getPosts());
    }

    @PostMapping("/insert/{id}")
    public ApiResponse<PostResponseDto.PostJoinResponseDto> createPost(@PathVariable Long id, @RequestBody PostRequestDto.PostSaveRequestDto post) {
        Post savedPost = postService.savePost(post, id);
        return ApiResponse.onSuccess(PostConverter.toPostSaveRequestDto(savedPost));
    }

    @PostMapping("/update/{id}")
    public ApiResponse<PostResponseDto.PostJoinResponseDto> updatePost(@PathVariable Long id, @RequestBody PostRequestDto.PostSaveRequestDto post) {
        return ApiResponse.onSuccess(PostConverter.toPostSaveRequestDto(postService.updatePost(id, post)));
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ApiResponse.onSuccess("삭제 완료");
    }
}
