package umc.practice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.repository.RegionRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionQueryServiceImpl implements RegionQueryService{
    private final RegionRepository regionRepository;
    @Override
    public boolean existsByName(String regionName) {
        return regionRepository.existsByRegionName(regionName);
    }
}
