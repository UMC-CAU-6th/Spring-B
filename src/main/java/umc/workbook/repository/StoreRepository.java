package umc.workbook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook.domain.entity.Review;
import umc.workbook.domain.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
