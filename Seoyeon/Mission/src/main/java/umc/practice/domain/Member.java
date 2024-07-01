package umc.practice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.practice.domain.common.BaseEntity;
import umc.practice.domain.enums.Gender;
import umc.practice.domain.enums.MemberStatus;
import umc.practice.domain.mapping.MemberFoodPrefer;
import umc.practice.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Member extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    //@Column(nullable = false)
    private String password;

    @Column(columnDefinition = "VARCHAR(10)")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthday;

    @Column
    private String address;

    //@Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    @ColumnDefault("0")
    private long points;

    private LocalDate inactivateDate;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList=new ArrayList<>();

    @OneToMany(mappedBy = "writer",cascade = CascadeType.ALL)
    private List<Review> reviewList=new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberFoodPrefer> memberFoodPreferList=new ArrayList<>();


}
