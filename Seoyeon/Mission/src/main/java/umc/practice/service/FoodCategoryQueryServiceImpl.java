package umc.practice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.repository.FoodCategoryRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService{
    private final FoodCategoryRepository foodCategoryRepository;
    @Override
    public boolean existsCategory(Long id) {
        return foodCategoryRepository.existsById(id);
    }
}
