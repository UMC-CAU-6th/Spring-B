package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Review;
import umc.domain.Store;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByStore(Store store);
}
