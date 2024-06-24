package com.example.umc.mission.domain;

import com.example.umc.mission.domain.enums.Gender;
import com.example.umc.mission.domain.enums.MemberStatus;
import com.example.umc.mission.domain.enums.SocialType;
import com.example.umc.mission.domain.mapping.Agreement;
import com.example.umc.mission.domain.mapping.MembersMission;
import com.example.umc.mission.domain.mapping.PreferrenceofFood;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String name;

    @Column(nullable = false, length = 50)
    private String address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDate inactiveDate;

    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Agreement> agreementList = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<PreferrenceofFood> preferrenceofFoodList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MembersMission> membersMissionList = new ArrayList<>();


}