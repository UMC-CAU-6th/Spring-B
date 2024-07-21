package com.example.umc.mission.service.ReviewService;

import com.example.umc.mission.apiPayload.code.status.ErrorStatus;
import com.example.umc.mission.apiPayload.exception.handler.MemberHandler;
import com.example.umc.mission.apiPayload.exception.handler.StoreHandler;
import com.example.umc.mission.aws.s3.AmazonS3Manager;
import com.example.umc.mission.converter.ReviewConverter;
import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.Review;
import com.example.umc.mission.domain.Store;
import com.example.umc.mission.domain.Uuid;
import com.example.umc.mission.repository.*;
import com.example.umc.mission.web.dto.request.StoreRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final MemberRepository memberRepository;

    private final ReviewRepository reviewRepository;

    private final StoreRepository storeRepository;

    private final AmazonS3Manager s3Manager;

    private final UuidRepository uuidRepository;

    private final ReviewImageRepository reviewImageRepository;

    public Review saveReview(StoreRequestDTO.postReviewDTO request, MultipartFile reviewPicture){

        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Member member =memberRepository.findById(request.getUserId()).orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Review newReview = ReviewConverter.toReivew(request, store, member);

        String uuid = UUID.randomUUID().toString();
        Uuid saveUuid = uuidRepository.save(Uuid.builder()
                .uuid(uuid).build());

        String pictureUrl = s3Manager.uploadFile(s3Manager.generateReviewKeyName(saveUuid), reviewPicture);


        reviewImageRepository.save(ReviewConverter.toReviewImage(pictureUrl,newReview));
        return reviewRepository.save(newReview);
    }

    public Long deleteReview(Long reviewId){

        Review review = reviewRepository.findById(reviewId).orElseThrow(()->new StoreHandler(ErrorStatus.REVIEW_NOT_FOUND));
        s3Manager.deleteImage(review.getReviewImage().getPictureUrl());

        Long storeId = review.getStore().getId();
        reviewRepository.delete(review);
        return storeId;
    }
}
