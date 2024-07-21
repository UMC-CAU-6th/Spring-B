package com.example.umc.mission.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReasonDTO {

    private String message;
    private String code;
    private Boolean isSuccess;
    private HttpStatus httpStatus;
}
