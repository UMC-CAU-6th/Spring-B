package umc.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.apiPayload.code.exception.handler.TempHandler;
import umc.practice.apiPayload.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {
    @Override
    public void checkFlag(Integer flag){
        if(flag==1) throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
