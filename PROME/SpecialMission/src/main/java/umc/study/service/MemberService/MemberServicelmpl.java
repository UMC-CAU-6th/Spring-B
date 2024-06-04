package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.TempHandler;
import umc.study.converter.MemberConverter;
import umc.study.domain.Member;
import umc.study.repository.MemberRepository;
import umc.study.web.dto.MemberDto.MemberRequsetDto;
import umc.study.web.dto.MemberDto.MemberResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServicelmpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member saveMember(MemberRequsetDto.MemberSaveRequestDto member) {
        Member newMember = MemberConverter.toMemberSaveEntity(member);
        return memberRepository.save(newMember);
    }

    @Override
    public List<MemberResponseDto.MemberJoinResponseDto> getMembers() {
        return memberRepository.findAll().stream().map(member -> {
            MemberResponseDto.MemberJoinResponseDto dto = new MemberResponseDto.MemberJoinResponseDto();
            dto.setMemberId(member.getMemberId());
            dto.setName(member.getName());
            dto.setNickname(member.getNickname());
            dto.setCreatedAt(member.getCreatedAt());
            dto.setUpdatedAt(member.getUpdatedAt());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public Member updateNickname(Long id, MemberRequsetDto.MemberUpdateRequestDto dto) {
        Member prevmember = memberRepository.findById(id).orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        prevmember.setNickname(dto.getNickname());
        return prevmember;
    }

    @Override
    public void deleteMember(Long id) {
        if (memberRepository.findById(id).isEmpty()) {
            throw new TempHandler(ErrorStatus.MEMBER_NOT_FOUND);
        }
        memberRepository.deleteById(id);
    }
}
