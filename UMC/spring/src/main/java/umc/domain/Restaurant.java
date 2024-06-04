package umc.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long identificationNum;

    @Column(nullable = false, length = 20)
    private String restName;

    @Column(nullable = false, length = 10)
    private String restType;

    @Column(nullable = false, length = 30)
    private String location;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Mission> missions = new ArrayList<>();
}
