package UMC.workbook.apiPayload.exception.handler;

import UMC.workbook.apiPayload.code.BaseErrorCode;
import UMC.workbook.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}