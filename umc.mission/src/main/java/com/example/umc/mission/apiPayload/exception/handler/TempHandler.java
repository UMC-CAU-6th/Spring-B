package com.example.umc.mission.apiPayload.exception.handler;

import com.example.umc.mission.apiPayload.code.BaseErrorCode;
import com.example.umc.mission.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
