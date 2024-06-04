package UMC.workbook.web.controller;

import UMC.workbook.apiPayload.ApiResponse;
import UMC.workbook.apiPayload.code.status.SuccessStatus;
import UMC.workbook.converter.TempConverter;
import UMC.workbook.service.TempService.TempQueryService;
import UMC.workbook.web.dto.TempResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




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