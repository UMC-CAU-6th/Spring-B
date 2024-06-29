package umc.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
