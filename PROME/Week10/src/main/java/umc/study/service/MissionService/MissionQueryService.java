package umc.study.service.MissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;

public interface MissionQueryService {
    Page<Mission> getMissionList(Long storeId, Integer page);
    Page<Mission> getMissionList(String nickname, Integer page);
}
