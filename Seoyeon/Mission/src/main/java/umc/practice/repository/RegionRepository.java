package umc.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.Region;

public interface RegionRepository extends JpaRepository<Region,Long> {
    public Region findByRegionName(String regionName);
}
