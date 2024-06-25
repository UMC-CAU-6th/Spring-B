package com.example.umc.mission.converter;

import com.example.umc.mission.domain.FoodCategory;
import com.example.umc.mission.domain.mapping.PreferrenceofFood;

import java.util.List;
import java.util.stream.Collectors;

public class PreferenceofFoodConverter {

    public static List<PreferrenceofFood> toPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        PreferrenceofFood.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
