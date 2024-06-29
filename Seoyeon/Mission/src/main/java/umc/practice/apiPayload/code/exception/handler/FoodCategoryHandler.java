package umc.practice.apiPayload.code.exception.handler;

import umc.practice.apiPayload.code.BaseErrorCode;
import umc.practice.apiPayload.code.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
