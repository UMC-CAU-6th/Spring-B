package umc.practice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.Review;
import umc.practice.domain.Store;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
}
