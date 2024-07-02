package umc.workbook.service.StoreService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.workbook.domain.entity.Mission;
import umc.workbook.domain.entity.Review;
import umc.workbook.domain.entity.Store;
import umc.workbook.repository.MissionRepository;
import umc.workbook.repository.ReviewRepository;
import umc.workbook.repository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@Getter
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page, Integer size){

        Store store = storeRepository.findById(StoreId)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        return reviewRepository.findAllByStore(store, PageRequest.of(page, size));
    }

    @Override
    public Page<Mission> getMissionList(Long StoreId, Integer page, Integer size){

        Store store = storeRepository.findById(StoreId)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        return missionRepository.findAllByStore(store, PageRequest.of(page, size));
    }
}
