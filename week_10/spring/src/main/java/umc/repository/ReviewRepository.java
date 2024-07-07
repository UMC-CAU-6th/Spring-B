package umc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Review;
import umc.domain.Store;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByStore(Store store);

    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
}
