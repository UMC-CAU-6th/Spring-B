package umc.workbook.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.workbook.domain.common.BaseEntity;
import umc.workbook.domain.entity.mapping.MemberAgree;
import umc.workbook.domain.entity.mapping.MemberMission;
import umc.workbook.domain.entity.mapping.MemberPrefer;
import umc.workbook.domain.enums.Gender;
import umc.workbook.domain.enums.MemberStatus;
import umc.workbook.domain.enums.SocialType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity  // 해당 class는 JPA의 entity임을 명시
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
// @Builder, @NoArgsConstructor, @AllArgsConstructor는 Builder Pattern을 사용하기 위함
public class Member extends BaseEntity {

    @Id   // 기본키 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // JPA가 통신을 하는 DBMS의 방식을 따름
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

//    @Column(nullable = false, length = 50)  // 원래 이메일을 소셜 로그인에서 처리한 다음에 나머지 정보를 기입 받는 것이 맞는 순서
                                              // 여기서는 소셜 로그인 일단은 없기 때문에 이메일은 nullable로 바꾸고 진행
    private String email;

    @ColumnDefault("0")
    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
    // minor changes
}