package umc.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory,Long> {
}
