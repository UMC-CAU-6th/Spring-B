package umc.service.Store;

import org.springframework.data.domain.Page;
import umc.domain.Mission;
import umc.domain.Review;
import umc.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long storeId, Integer page);

    Page<Mission> getMissionList(Long storeId, Integer page);
}
