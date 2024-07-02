package umc.workbook.service.MemberService;

import umc.workbook.domain.entity.Member;
import umc.workbook.web.dto.Member.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
