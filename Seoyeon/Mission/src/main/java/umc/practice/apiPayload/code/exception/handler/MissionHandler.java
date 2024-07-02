package umc.practice.apiPayload.code.exception.handler;

import umc.practice.apiPayload.code.BaseErrorCode;
import umc.practice.apiPayload.code.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode code) {
        super(code);
    }
}
