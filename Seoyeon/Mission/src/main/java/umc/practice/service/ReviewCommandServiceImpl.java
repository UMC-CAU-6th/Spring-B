package umc.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.converter.ReviewConverter;
import umc.practice.domain.Member;
import umc.practice.domain.Review;
import umc.practice.domain.Store;
import umc.practice.repository.MemberRepository;
import umc.practice.repository.ReviewRepository;
import umc.practice.repository.StoreRepository;
import umc.practice.web.dto.ReviewRequestDto;
import umc.practice.web.dto.ReviewResponseDto;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Review writeReview(ReviewRequestDto.WriteReviewRequestDto request) {
        Review review= ReviewConverter.toReview(request);

        Member writer = memberRepository.findById(request.getWriterId()).get();
        Store store = storeRepository.findById(request.getStoreId()).get();
        review.setStore(store);
        review.setWriter(writer);

        return reviewRepository.save(review);
    }
}
