package umc.workbook.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.apiPayload.code.status.SuccessStatus;
import umc.workbook.converter.StoreConverter;
import umc.workbook.domain.entity.Store;
import umc.workbook.service.StoreService.StoreCommandService;
import umc.workbook.web.dto.Store.StoreRequestDTO;
import umc.workbook.web.dto.Store.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/stores")
@Slf4j
public class StoreController {

    private final StoreCommandService storeCommandService;

    // 특정 지역에 가게 추가
    @PostMapping("/")
    @Operation(summary = "가게 추가", description = "특정 지역에 가게를 추가합니다.")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> storeCreate(
            @RequestParam Long regionId,
            @RequestBody StoreRequestDTO.CreateStoreRequestDTO request
            ) {
        Store newStore = storeCommandService.createStore(regionId, request);
        return ApiResponse.onSuccess(
                SuccessStatus.Store_OK,
                StoreConverter.toCreateResultDTO(newStore)
        );
    }

}
