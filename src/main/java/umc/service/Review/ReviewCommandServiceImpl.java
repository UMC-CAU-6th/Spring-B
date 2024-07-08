package umc.service.Review;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.MemberHandler;
import umc.apiPayload.exception.handler.StoreHandler;
import umc.converter.ReviewConverter;
import umc.domain.Member;
import umc.domain.Review;
import umc.domain.Store;
import umc.repository.MemberRepository;
import umc.repository.ReviewRepository;
import umc.repository.StoreRepository;
import umc.web.dto.Review.ReviewRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandServiceImpl implements ReviewCommandService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.ReviewJoinDto request) {

        Member newMember = memberRepository.findById(request.getMemberId()).orElseThrow(
                () -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)
        );

        Store newStore = storeRepository.findById(request.getStoreId()).orElseThrow(
                () -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND)
        );

        Review newReview = ReviewConverter.toReview(request, newMember, newStore);

        List<Review> reviews = reviewRepository.findByStore(newStore);
        float sum = newReview.getScore();
        for(Review review : reviews) {
            sum += review.getScore();
        }
        float avgScore = sum / (reviews.size() + 1);

        newStore.setScore(avgScore);

        return reviewRepository.save(newReview);
    }
}
