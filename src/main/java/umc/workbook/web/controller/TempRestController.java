package umc.workbook.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.apiPayload.code.status.SuccessStatus;
import umc.workbook.converter.TempConverter;
import umc.workbook.service.TempService.TempQueryService;
import umc.workbook.web.dto.TempResponseDTO;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;
    @GetMapping("/test")
    public ApiResponse<TempResponseDTO.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(
                SuccessStatus.Temp_OK,
                TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponseDTO.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(
                SuccessStatus.Temp_OK,
                TempConverter.toTempExceptionDTO(flag));
    }
}
