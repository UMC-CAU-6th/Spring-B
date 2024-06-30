package umc.practice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.repository.StoreRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;

    @Override
    public boolean existsById(Long id) {
        return storeRepository.existsById(id);
    }
}
