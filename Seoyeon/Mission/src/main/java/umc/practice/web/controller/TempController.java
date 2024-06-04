package umc.practice.web.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.practice.apiPayload.ApiResponse;
import umc.practice.converter.TempConverter;
import umc.practice.service.TempQueryServiceImpl;
import umc.practice.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempController {
    private final TempQueryServiceImpl tempQueryServiceImpl;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDto> testApi(){
        return ApiResponse.onSuccess(TempConverter.toTempDto());
    }
    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDto> exceptionApi(
            @RequestParam("flag")Integer flag
    ){
        tempQueryServiceImpl.checkFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDto(flag));
    }
}
