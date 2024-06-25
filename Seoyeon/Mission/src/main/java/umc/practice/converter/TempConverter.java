package umc.practice.converter;

import umc.practice.web.dto.TempResponse;

public class TempConverter {
    public static TempResponse.TempTestDto toTempDto(){
        return TempResponse.TempTestDto.builder()
                .testString("this is test")
                .build();
    }
    public static TempResponse.TempExceptionDto toTempExceptionDto(Integer flag){
        return TempResponse.TempExceptionDto.builder()
                .flag(flag).build();
    }
}
