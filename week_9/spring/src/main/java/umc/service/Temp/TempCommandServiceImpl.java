package umc.service.Temp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.TempHandler;


@Service
@RequiredArgsConstructor
public class TempCommandServiceImpl implements TempCommandService {
    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}