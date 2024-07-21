package com.example.umc.mission.service.StoreService;

import com.example.umc.mission.domain.Review;
import com.example.umc.mission.domain.Store;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);
}
