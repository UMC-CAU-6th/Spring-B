package umc.practice.service;

import org.springframework.data.domain.Page;
import umc.practice.domain.Mission;
import umc.practice.domain.Store;

public interface MissionQueryService {
    public Page<Mission> getMissionList(Long storeId, int page);
    public Page<Mission> getChallengingMissionList(Long memberId, int page);
}
