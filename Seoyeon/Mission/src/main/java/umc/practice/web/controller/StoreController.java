package umc.practice.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.practice.apiPayload.ApiResponse;
import umc.practice.converter.StoreConverter;
import umc.practice.domain.Store;
import umc.practice.service.StoreCommandService;
import umc.practice.web.dto.StoreRequestDto;
import umc.practice.web.dto.StoreResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {
    private final StoreCommandService storeCommandService;

    @PostMapping
    public ApiResponse<StoreResponseDto.addStoreResponseDto> addStore(@RequestBody @Valid  StoreRequestDto.AddStoreRequestDto request){
        Store store=storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toStoreResponseDto(store));
    }
}
