package com.example.umc.mission.apiPayload.exception.handler;

import com.example.umc.mission.apiPayload.code.BaseErrorCode;
import com.example.umc.mission.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {

    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
