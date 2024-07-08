package umc.apiPayload.exception.handler;

import umc.apiPayload.code.BaseErrorCode;
import umc.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode errorcode) {
        super(errorcode);
    }
}
