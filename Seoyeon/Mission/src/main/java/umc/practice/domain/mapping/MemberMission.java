package umc.practice.domain.mapping;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.practice.domain.Mission;
import umc.practice.domain.Member;
import umc.practice.domain.common.BaseEntity;
import umc.practice.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'IN_PROGRESS'")
    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mission_id")
    private Mission mission;

    public void setMember(Member member) {
        if(member!=null)
            member.getMemberMissionList().remove(this);
        this.member=member;
        if(member!=null)
        member.getMemberMissionList().add(this);
    }
    public void setMission(Mission mission) {
        if(mission!=null)
            mission.getMemberMissionList().remove(this);
        this.mission=mission;
        if(mission!=null)
            mission.getMemberMissionList().add(this);
    }
}
