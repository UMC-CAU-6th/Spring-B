package umc.service.Store;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.RegionHandler;
import umc.converter.StoreConverter;
import umc.domain.Region;
import umc.domain.Store;
import umc.repository.RegionRepository;
import umc.repository.StoreRepository;
import umc.validation.annotation.ExistRegions;
import umc.web.dto.Store.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private RegionRepository regionRepository;


    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.StoreJoinDto request) {

        Region newRegion = regionRepository.findById(request.getRegionId()).orElseThrow(
                () -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND)
        );

        Store newStore = StoreConverter.toStore(request, newRegion);

        return storeRepository.save(newStore);
    }

}
