package UMC.workbook.domain.entity.mapping;

import UMC.workbook.domain.common.BaseEntity;
import UMC.workbook.domain.entity.FoodCategory;
import UMC.workbook.domain.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long memberId; //-> 연관 관계 매핑으로 변경
    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩
    @JoinColumn(name = "member_id")
    private Member member;

    //private Long categoryId; //-> 연관 관계 매핑으로 변경
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

    // created_at, updated_at in BaseEntity
}
