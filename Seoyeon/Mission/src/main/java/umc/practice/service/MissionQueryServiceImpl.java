package umc.practice.service;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.practice.domain.Mission;
import umc.practice.domain.Store;
import umc.practice.repository.MissionRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class MissionQueryServiceImpl implements MissionQueryService{
    private final MissionRepository missionRepository;
    private final StoreQueryService storeQueryService;

    @Override
    public Page<Mission> getMissionList(Long storeId, int page) {
        Store store=storeQueryService.findById(storeId).get();
        return missionRepository.findAllByStore(store, PageRequest.of(page,10));
    }
}
