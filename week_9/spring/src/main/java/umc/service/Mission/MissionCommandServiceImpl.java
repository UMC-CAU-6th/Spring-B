package umc.service.Mission;

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
import umc.converter.ReviewConverter;
import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.Review;
import umc.domain.Store;
import umc.domain.mapping.MemberMission;
import umc.repository.*;
import umc.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.web.dto.Mission.MissionRequestDTO;
import umc.web.dto.Review.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public Mission joinMission(MissionRequestDTO.MissionJoinDto request) {

        Store newStore = storeRepository.findById(request.getStoreId()).orElseThrow(
                () -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND)
        );

        Mission newMission = MissionConverter.toMission(request, newStore);

        return missionRepository.save(newMission);

    }
}
