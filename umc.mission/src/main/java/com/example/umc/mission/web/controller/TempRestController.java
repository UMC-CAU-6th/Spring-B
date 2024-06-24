package com.example.umc.mission.web.controller;

import com.example.umc.mission.apiPayload.ApiResponse;
import com.example.umc.mission.converter.TempConverter;
import com.example.umc.mission.web.dto.TempResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testApi(){

        return ApiResponse.onSucccess(TempConverter.toTempTestDTO());
    }
}
