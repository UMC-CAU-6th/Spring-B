package umc.workbook.service.StoreService;

import org.springframework.data.domain.Page;
import umc.workbook.domain.entity.Review;
import umc.workbook.domain.entity.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page, Integer size);
}
