package com.example.umc.mission.service.MemberService;

import com.example.umc.mission.domain.Review;
import org.springframework.data.domain.Page;

public interface MemberQueryService {

    Page<Review> getReviewList(Long MemberId, Integer page);
}
