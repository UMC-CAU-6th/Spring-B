package umc.workbook.service.StoreService;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import umc.workbook.converter.StoreConverter;
import umc.workbook.domain.entity.Region;
import umc.workbook.domain.entity.Store;
import umc.workbook.repository.RegionRepository;
import umc.workbook.repository.StoreRepository;
import umc.workbook.web.dto.Store.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    public Store createStore(Long regionId, StoreRequestDTO.CreateStoreRequestDTO request) {

        Store newStore = StoreConverter.toStore(request);
        Region getRegion = regionRepository.findById(regionId).get();
        newStore.setRegion(getRegion);
        Store savedStore = storeRepository.save(newStore);

        return savedStore;
    }
}
