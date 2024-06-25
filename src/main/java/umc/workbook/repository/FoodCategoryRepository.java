package umc.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook.domain.entity.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
