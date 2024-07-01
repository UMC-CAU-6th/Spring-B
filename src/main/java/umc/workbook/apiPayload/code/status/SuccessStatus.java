package umc.workbook.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.workbook.apiPayload.code.BaseCode;
import umc.workbook.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    Temp_OK(HttpStatus.OK, "TEMP_0000", "성공입니다."),

    // 멤버 관련 응답
    Member_OK(HttpStatus.OK, "MEMBER_1000", "성공입니다."),

    // 가게 관련 응답
    Store_OK(HttpStatus.OK, "STORE_2000", "성공입니다."),

    // 리뷰 관련 응답
    Review_OK(HttpStatus.OK, "REVIEW_3000", "성공입니다."),

    // 미션 관련 응답
    Mission_OK(HttpStatus.OK, "MISSION_4000", "성공입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
