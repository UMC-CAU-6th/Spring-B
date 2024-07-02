package umc.practice.apiPayload.code.exception;

import lombok.AllArgsConstructor;
import umc.practice.apiPayload.code.BaseErrorCode;
import umc.practice.apiPayload.code.ErrorReasonDTO;

@AllArgsConstructor
public class GeneralException extends RuntimeException{
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason(){
        return this.code.getReason();
    }
    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
