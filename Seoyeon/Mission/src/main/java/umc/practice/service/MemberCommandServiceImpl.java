package umc.practice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.practice.converter.MemberConverter;
import umc.practice.converter.MemberFoodPreferConverter;
import umc.practice.domain.FoodCategory;
import umc.practice.domain.Member;
import umc.practice.domain.mapping.MemberFoodPrefer;
import umc.practice.repository.FoodCategoryRepository;
import umc.practice.repository.MemberRepository;
import umc.practice.web.dto.MemberRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandServiceImpl implements MemberCommandService{
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member signUp(MemberRequestDto.signUpRequestDto requestDto) {
        Member member= MemberConverter.toMember(requestDto);

        List<FoodCategory> foodCategoryList=requestDto.getFavorList().stream()  //foodCategory id를 가지고 FoodCategory list 생성
                .map(category->{
                    return foodCategoryRepository.findById(category).get();
                }).toList();

        List<MemberFoodPrefer> memberFoodPreferList= MemberFoodPreferConverter.toMemberFoodPreferList(foodCategoryList);
        memberFoodPreferList.forEach(memberFoodPrefer -> {memberFoodPrefer.setMember(member);});    //member 와의 양방향 매핑관계 설정
        return memberRepository.save(member);
    }
}
