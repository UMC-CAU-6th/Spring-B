package umc.study.service.PostService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.TempHandler;
import umc.study.converter.PostConverter;
import umc.study.domain.Member;
import umc.study.domain.Post;
import umc.study.repository.MemberRepository;
import umc.study.repository.PostRepository;
import umc.study.web.dto.PostDto.PostRequestDto;
import umc.study.web.dto.PostDto.PostResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServicelmpl implements PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Override
    public Post savePost(PostRequestDto.PostSaveRequestDto post, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Post newPost = PostConverter.toPostSaveEntity(post, member);
        return postRepository.save(newPost);
    }

    @Override
    public List<PostResponseDto.PostJoinResponseDto> getPosts() {
        return postRepository.findAll().stream().map(post -> {
            PostResponseDto.PostJoinResponseDto dto = new PostResponseDto.PostJoinResponseDto();
            dto.setPostId(post.getPostId());
            dto.setContent(post.getContent());
            dto.setCreatedAt(post.getCreatedAt());
            dto.setUpdatedAt(post.getUpdatedAt());
            dto.setMemberId(post.getMember().getMemberId());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public Post updatePost(Long id, PostRequestDto.PostSaveRequestDto post) {
        Post updatePost = postRepository.findById(id).orElseThrow(() -> new TempHandler(ErrorStatus.POST_NOT_FOUND));
        updatePost.setContent(post.getContent());
        return postRepository.save(updatePost);
    }

    @Override
    public void deletePost(Long id) {
        if (postRepository.findById(id).isEmpty()) {
            throw new TempHandler(ErrorStatus.POST_NOT_FOUND);
        }
        postRepository.deleteById(id);
    }
}
