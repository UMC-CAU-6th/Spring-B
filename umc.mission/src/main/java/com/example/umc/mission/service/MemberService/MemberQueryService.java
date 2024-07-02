package com.example.umc.mission.service.MemberService;

import com.example.umc.mission.domain.Review;
import com.example.umc.mission.domain.mapping.MembersMission;
import org.springframework.data.domain.Page;

public interface MemberQueryService {

    Page<MembersMission> getChallengingMissionList(Long memberId, Integer page);

    Page<Review> getReviewList(Long MemberId, Integer page);
}
