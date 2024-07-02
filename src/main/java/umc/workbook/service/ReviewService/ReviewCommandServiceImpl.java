package umc.workbook.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import umc.workbook.converter.ReviewConverter;
import umc.workbook.domain.entity.Member;
import umc.workbook.domain.entity.Review;
import umc.workbook.domain.entity.Store;
import umc.workbook.repository.MemberRepository;
import umc.workbook.repository.ReviewRepository;
import umc.workbook.repository.StoreRepository;
import umc.workbook.web.controller.ReviewController;
import umc.workbook.web.dto.Review.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    public Review createReview(Long memberId, ReviewRequestDTO.CreateReviewRequestDTO request) {

        Review newReview = ReviewConverter.toReview(request);
        Member getMember = memberRepository.findById(memberId).get();
        Store getStore = storeRepository.findById(request.getStoreId()).get();
        newReview.setMember(getMember);
        newReview.setStore(getStore);

        Review savedReview = reviewRepository.save(newReview);

        return savedReview;

    }


}
