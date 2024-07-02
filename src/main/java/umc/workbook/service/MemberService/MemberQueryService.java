package umc.workbook.service.MemberService;

import org.springframework.data.domain.Page;
import umc.workbook.domain.entity.Member;
import umc.workbook.domain.entity.Review;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);
    Page<Review> getReviewList(Long MemberId, Integer page, Integer size);
}
