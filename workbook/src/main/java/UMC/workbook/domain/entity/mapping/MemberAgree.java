package UMC.workbook.domain.entity.mapping;

import UMC.workbook.domain.common.BaseEntity;
import UMC.workbook.domain.entity.Member;
import UMC.workbook.domain.entity.Terms;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberAgree extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long memberId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //private Long termsId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_id")
    private Terms terms;

    // created_at, updated_at in BaseEntity

}
