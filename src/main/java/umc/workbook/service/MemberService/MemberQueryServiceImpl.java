package umc.workbook.service.MemberService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.workbook.domain.entity.Member;
import umc.workbook.domain.entity.Review;
import umc.workbook.repository.MemberRepository;
import umc.workbook.repository.ReviewRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@Getter
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long MemberId, Integer page, Integer size){

        Member member = memberRepository.findById(MemberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        return reviewRepository.findAllByMember(member, PageRequest.of(page, size));
    }
}
