package umc.workbook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.workbook.domain.entity.Member;
import umc.workbook.domain.entity.Review;
import umc.workbook.domain.entity.Store;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByStore(Store store, PageRequest pageable);

    Page<Review> findAllByMember(Member member, PageRequest pageable);
}
