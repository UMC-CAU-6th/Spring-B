package umc.practice.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.practice.apiPayload.code.BaseErrorCode;
import umc.practice.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    //일반적인 exception
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),

    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST,"MEMBER4001","사용자가 존재하지 않습니다"),
    NICKNAME_NOT_EXISTS(HttpStatus.BAD_REQUEST,"MEMBER4002","닉네임은 필수입니다."),

    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,"FOODCATEGORY4000","해당 카테고리가 존재하지 않습니다."),

    //지역 관련
    REGION_NOT_EXISTS(HttpStatus.NOT_FOUND,"REGION4000","해당 지역이 등록되어있지 않습니다."),

    //가게 관련
    STORE_NOT_EXISTS(HttpStatus.NOT_FOUND,"STORE4000","가게가 존재하지 않습니다"),

    //미션 관련
    MISSION_DATE_NOT_VALID(HttpStatus.BAD_REQUEST,"MISSION4000","시작일과 마감일이 유효하지 않습니다."),

    //테스트용
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트")
    ;

    // 멤버 관련 응답

    // ~~~ 관련 응답 ....


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;



    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();    }
}
