package umc.practice.apiPayload.code.exception.handler;

import umc.practice.apiPayload.code.BaseErrorCode;
import umc.practice.apiPayload.code.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
