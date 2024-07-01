package umc.workbook.apiPayload.exception.handler;

import umc.workbook.apiPayload.code.BaseErrorCode;
import umc.workbook.apiPayload.exception.GeneralException;
import umc.workbook.domain.entity.FoodCategory;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
