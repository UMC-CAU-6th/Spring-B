package umc.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.converter.MissionConverter;
import umc.practice.domain.Mission;
import umc.practice.domain.Store;
import umc.practice.repository.MissionRepository;
import umc.practice.repository.StoreRepository;
import umc.practice.web.dto.MissionRequestDto;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    @Override
    public Mission addMission(MissionRequestDto.AddMissionRequestDto requestDto) {
        Mission mission= MissionConverter.toMission(requestDto);
        Store store = storeRepository.findById(requestDto.getStoreId()).get();
        mission.setStore(store);

        return missionRepository.save(mission);
    }
}
