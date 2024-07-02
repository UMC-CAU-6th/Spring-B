package com.example.umc.mission.service.MissionService;

import com.example.umc.mission.domain.Mission;
import org.springframework.data.domain.Page;

public interface MissionQueryService {

    Page<Mission> getMissions(Long StoreId, Integer page);
}
