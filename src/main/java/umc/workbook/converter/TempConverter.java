package umc.workbook.converter;

import umc.workbook.web.dto.Temp.TempResponseDTO;

public class TempConverter {

    public static TempResponseDTO.TempTestDTO toTempTestDTO(){
        return TempResponseDTO.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }

    public static TempResponseDTO.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponseDTO.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
