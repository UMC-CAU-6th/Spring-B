package umc.workbook.domain.entity.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.workbook.domain.common.BaseEntity;
import umc.workbook.domain.entity.Member;
import umc.workbook.domain.entity.Terms;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberAgree extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberAgreeId;

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
