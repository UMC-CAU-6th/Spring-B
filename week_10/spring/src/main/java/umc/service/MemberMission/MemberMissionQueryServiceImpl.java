package umc.service.MemberMission;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.MemberHandler;
import umc.apiPayload.exception.handler.MissionHandler;
import umc.domain.Member;
import umc.domain.Mission;
import umc.repository.MemberMissionRepository;
import umc.repository.MemberRepository;
import umc.repository.MissionRepository;
import umc.web.dto.MemberMission.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final MissionRepository missionRepository;

    @Autowired
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean checkMemberMission(Long memberId, Long missionId) {
        Member newMember = memberRepository.findById(memberId).orElseThrow(
                () -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)
        );

        Mission newMission = missionRepository.findById(missionId).orElseThrow(
                () -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND)
        );

        return memberMissionRepository.existsByMissionAndMember(newMission, newMember);
    }
}
