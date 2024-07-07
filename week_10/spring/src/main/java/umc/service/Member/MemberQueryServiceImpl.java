package umc.service.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.Review;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.MemberMission;
import umc.repository.MemberMissionRepository;
import umc.repository.MemberRepository;
import umc.repository.MissionRepository;
import umc.repository.ReviewRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final ReviewRepository reviewRepository;
    @Autowired
    private MissionRepository missionRepository;
    @Autowired
    private MemberMissionRepository memberMissionRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();

        Page<Review> MemberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return MemberPage;
    }

    @Override
    public Page<MemberMission> getMemberMissionList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();

        Page<MemberMission> MissionPage = memberMissionRepository.findAllByMemberAndStatus(
                member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));

        return MissionPage;
    }

}
