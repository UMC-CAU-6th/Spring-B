package umc.practice.converter;

import umc.practice.domain.FoodCategory;
import umc.practice.domain.mapping.MemberFoodPrefer;

import java.util.ArrayList;
import java.util.List;

public class MemberFoodPreferConverter {
    public static List<MemberFoodPrefer> toMemberFoodPreferList(List<FoodCategory> foodCategoryList){
        return foodCategoryList.stream()
                .map(category->{
                    return MemberFoodPrefer.builder()
                            .foodCategory(category)
                            .build();
                }).toList();
    }
}
