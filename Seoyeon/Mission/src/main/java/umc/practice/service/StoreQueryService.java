package umc.practice.service;

import org.springframework.data.domain.Page;
import umc.practice.domain.Review;
import umc.practice.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    public boolean existsById(Long id);
    public Optional<Store> findById(Long id);
    Page<Review> getReviewList(Long storeId, int page);

}
