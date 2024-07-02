package umc.practice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.practice.domain.Review;
import umc.practice.domain.Store;
import umc.practice.repository.ReviewRepository;
import umc.practice.repository.StoreRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public boolean existsById(Long id) {
        return storeRepository.existsById(id);
    }

    @Override
    public Optional<Store> findById(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long storeId, int page) {
        Store store=findById(storeId).get();
        return reviewRepository.findAllByStore(store, PageRequest.of(page,10));
    }
}
