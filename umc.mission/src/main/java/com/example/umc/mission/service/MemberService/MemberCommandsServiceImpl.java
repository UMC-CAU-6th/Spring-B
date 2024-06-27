package com.example.umc.mission.service.MemberService;

import com.example.umc.mission.apiPayload.code.status.ErrorStatus;
import com.example.umc.mission.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.umc.mission.converter.MemberConverter;
import com.example.umc.mission.converter.PreferenceofFoodConverter;
import com.example.umc.mission.domain.FoodCategory;
import com.example.umc.mission.domain.Member;
import com.example.umc.mission.domain.mapping.PreferrenceofFood;
import com.example.umc.mission.repository.FoodCategoryRepository;
import com.example.umc.mission.repository.MemberRepository;
import com.example.umc.mission.web.dto.request.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandsServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request){

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<PreferrenceofFood> preferrenceofFoodList = PreferenceofFoodConverter.toPreferList(foodCategoryList);

        preferrenceofFoodList.forEach(preferrenceofFood -> {preferrenceofFood.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
