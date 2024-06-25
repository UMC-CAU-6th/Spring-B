package umc.workbook.domain.entity.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.workbook.domain.common.BaseEntity;
import umc.workbook.domain.entity.FoodCategory;
import umc.workbook.domain.entity.Member;

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

    public void setMember(Member member) {
        if (this.member != null)
            member.getMemberPreferList().remove(this);
        this.member = member;
        member.getMemberPreferList().add(this);
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }


    // created_at, updated_at in BaseEntity
}
