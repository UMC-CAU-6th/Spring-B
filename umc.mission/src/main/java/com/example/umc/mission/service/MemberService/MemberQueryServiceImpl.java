package com.example.umc.mission.service.MemberService;

import com.example.umc.mission.apiPayload.code.status.ErrorStatus;
import com.example.umc.mission.apiPayload.exception.handler.MemberHandler;
import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.Review;
import com.example.umc.mission.repository.MemberRepository;
import com.example.umc.mission.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;

    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long MemberId, Integer page){
        Member member = memberRepository.findById(MemberId).get();

        Page<Review> MemberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return MemberPage;
    }

}
