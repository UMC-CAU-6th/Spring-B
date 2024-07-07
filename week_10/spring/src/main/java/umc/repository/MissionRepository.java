package umc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.Review;
import umc.domain.Store;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.MemberMission;


public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
