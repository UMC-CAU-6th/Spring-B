package umc.study.service.MissionService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.repository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServicelmpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();
        Page<Mission> storePage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return storePage;
    }

    @Override
    public Page<Mission> getMissionList(String nickname, Integer page) {
        Long memberId = memberRepository.findByName(nickname).getId();

        return null;
    }
}
