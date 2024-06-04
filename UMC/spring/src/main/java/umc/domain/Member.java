package umc.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.domain.common.BaseEntity;
import umc.domain.mapping.AssignedMission;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Date birth;

    @Column(nullable = false, length = 20)
    private String address;

    private Long mission_count;

    private Long point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<AssignedMission> assignedMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<FavoriteFood> favoriteFoods = new ArrayList<>();
}
