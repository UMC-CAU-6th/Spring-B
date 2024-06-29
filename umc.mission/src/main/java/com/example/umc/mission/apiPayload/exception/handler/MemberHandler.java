package com.example.umc.mission.apiPayload.exception.handler;

import com.example.umc.mission.apiPayload.code.BaseErrorCode;
import com.example.umc.mission.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
