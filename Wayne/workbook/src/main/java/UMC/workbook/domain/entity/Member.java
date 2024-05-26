package UMC.workbook.domain.entity;


import UMC.workbook.domain.common.BaseEntity;
import UMC.workbook.domain.entity.mapping.MemberAgree;
import UMC.workbook.domain.entity.mapping.MemberMission;
import UMC.workbook.domain.entity.mapping.MemberPrefer;
import UMC.workbook.domain.enums.Gender;
import UMC.workbook.domain.enums.MemberStatus;
import UMC.workbook.domain.enums.SocialType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity  // 해당 class는 JPA의 entity임을 명시
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
// @Builder, @NoArgsConstructor, @AllArgsConstructor는 Builder Pattern을 사용하기 위함
public class Member extends BaseEntity {

    @Id   // 기본키 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // JPA가 통신을 하는 DBMS의 방식을 따름
    private Long id;

    private String name;

    private String specAddress;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDate inactiveDate;

    private String email;

    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
