package com.example.umc.mission.apiPayload.exception.handler;

import com.example.umc.mission.apiPayload.code.BaseErrorCode;
import com.example.umc.mission.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
