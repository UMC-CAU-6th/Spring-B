package umc.practice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.practice.domain.Member;
import umc.practice.domain.Review;
import umc.practice.domain.Store;
@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByWriter(Member member, PageRequest pageRequest);
}
