package com.example.umc.mission.apiPayload.code.status;

import com.example.umc.mission.apiPayload.code.BaseErrorCode;
import com.example.umc.mission.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    //가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    //페이지 에러
    PAGE_FORBIDDEN(HttpStatus.BAD_REQUEST,"PAGE4001", "페이지 값이 음수입니다."),

    //멤버 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 존재하지 않습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수입니다."),

    //음식 선호도 에러
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "FOODCATEGORY4001", "해당하는 음식 카테코리가 존재하지 않습니다."),

    //지역 에러
    REGION_NOT_FOUND(HttpStatus.BAD_REQUEST, "REGION4001" ,"입력한 이름을 가진 지역이 존재하지 않습니다."),

    //가게 에러
    STORE_NOT_FOUND(HttpStatus.BAD_REQUEST, "STORE4001", "해당하는 가게가 존재하지 않습니다."),

    //미션 에러
    MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "MISSION4001", "미션이 존재하지 않습니다."),
    MISSION_IS_CHALLENGING(HttpStatus.BAD_REQUEST, "MISSION4002", "미션이 이미 도전 중입니다."),

    //Test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "FOR TEST");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason(){
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build()
                ;
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus(){
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
