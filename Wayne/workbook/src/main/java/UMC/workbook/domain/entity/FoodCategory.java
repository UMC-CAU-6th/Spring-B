package UMC.workbook.domain.entity;

import UMC.workbook.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String name;

//    @OneToMany(mappedBy = "food_category", cascade = CascadeType.ALL)
//    private List<MemberPrefer> memberPreferList = new ArrayList<>();
}
