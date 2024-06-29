package umc.practice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.converter.StoreConverter;
import umc.practice.domain.Region;
import umc.practice.domain.Store;
import umc.practice.repository.RegionRepository;
import umc.practice.repository.StoreRepository;
import umc.practice.web.dto.StoreRequestDto;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService{
    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Store addStore(StoreRequestDto.AddStoreRequestDto requestDto) {
        Store store= StoreConverter.toStore(requestDto);
        Region region=regionRepository.findByRegionName(requestDto.getRegion());    //region 설정
        store.setRegion(region);
        return storeRepository.save(store);
    }
}
