package umc.practice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.practice.domain.common.BaseEntity;
import umc.practice.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private long reward;

    @Column
    private long minimumPrice;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;

    @OneToMany(mappedBy = "mission",cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList=new ArrayList<>();

    public void setStore(Store store) {
        if(store!=null)
            store.getMissionList().remove(this);
        this.store = store;
        if(store!=null)
            store.getMissionList().add(this);
    }

}
