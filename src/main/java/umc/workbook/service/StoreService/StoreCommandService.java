package umc.workbook.service.StoreService;

import umc.workbook.domain.entity.Store;
import umc.workbook.web.dto.Store.StoreRequestDTO;

public interface StoreCommandService {

    Store createStore(Long regionId, StoreRequestDTO.CreateStoreRequestDTO request);
}
