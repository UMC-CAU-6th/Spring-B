package umc.practice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.Mission;
import umc.practice.domain.Store;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    public Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
