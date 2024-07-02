package umc.service.MemberMission;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.MemberHandler;
import umc.apiPayload.exception.handler.MissionHandler;
import umc.apiPayload.exception.handler.StoreHandler;
import umc.converter.MemberMissionConverter;
import umc.converter.MissionConverter;
import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.Store;
import umc.domain.mapping.MemberMission;
import umc.repository.MemberMissionRepository;
import umc.repository.MemberRepository;
import umc.repository.MissionRepository;
import umc.repository.StoreRepository;
import umc.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.web.dto.Mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    @Autowired
    private MemberMissionRepository memberMissionRepository;

    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public MemberMission joinMemberMission(MemberMissionRequestDTO.MemberMissionJoinDto request) {

        Member newMember = memberRepository.findById(request.getMemberId()).orElseThrow(
                () -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)
        );

        Mission newMission = missionRepository.findById(request.getMissionId()).orElseThrow(
                () -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND)
        );

        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request, newMember, newMission);

        return memberMissionRepository.save(newMemberMission);

    }
}
