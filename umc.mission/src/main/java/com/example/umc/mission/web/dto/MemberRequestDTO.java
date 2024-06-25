package com.example.umc.mission.web.dto;

import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDTO{
        String name;
        String address;
        Integer gender;
        Integer bYear;
        Integer bMonth;
        Integer bDay;
        List<Long> preferCategory;
    }
}
