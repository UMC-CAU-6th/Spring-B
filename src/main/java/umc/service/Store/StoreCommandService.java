package umc.service.Store;

import umc.domain.Store;
import umc.web.dto.Store.StoreRequestDTO;

public interface StoreCommandService {
    Store joinStore(StoreRequestDTO.StoreJoinDto request);
}
