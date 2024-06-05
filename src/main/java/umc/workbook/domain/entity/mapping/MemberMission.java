package umc.workbook.domain.entity.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.workbook.domain.common.BaseEntity;
import umc.workbook.domain.entity.Member;
import umc.workbook.domain.entity.Mission;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long memberId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //private Long missionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MissionStatus status;

    // created_at, updated_at in BaseEntity
}
