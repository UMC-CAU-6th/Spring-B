package umc.workbook.service.MissionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.workbook.converter.MissionConverter;
import umc.workbook.domain.entity.Mission;
import umc.workbook.domain.entity.Store;
import umc.workbook.repository.MemberRepository;
import umc.workbook.repository.MissionRepository;
import umc.workbook.repository.StoreRepository;
import umc.workbook.web.dto.Mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Mission createMission(Long storeId, MissionRequestDTO.CreateMissionRequestDTO request){
        Store getStore = storeRepository.findById(storeId).get();

        Mission newMission = MissionConverter.toMission(request);
        newMission.setStore(getStore);

        Mission savedMission = missionRepository.save(newMission);

        return savedMission;

    }

}
