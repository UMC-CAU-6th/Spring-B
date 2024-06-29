package com.example.umc.mission.service.ReviewService;

import com.example.umc.mission.apiPayload.code.status.ErrorStatus;
import com.example.umc.mission.apiPayload.exception.handler.MemberHandler;
import com.example.umc.mission.apiPayload.exception.handler.StoreHandler;
import com.example.umc.mission.converter.ReviewConverter;
import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.Review;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.repository.MemberRepository;
import com.example.umc.mission.repository.ReviewRepository;
import com.example.umc.mission.repository.StoreRepository;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final MemberRepository memberRepository;

    private final ReviewRepository reviewRepository;

    private final StoreRepository storeRepository;

    public Review saveReview(StoreRequestDTO.postReviewDTO request){

        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Member member =memberRepository.findById(request.getUserId()).orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Review newReview = ReviewConverter.toReivew(request, store, member);

        return reviewRepository.save(newReview);
    }
}
