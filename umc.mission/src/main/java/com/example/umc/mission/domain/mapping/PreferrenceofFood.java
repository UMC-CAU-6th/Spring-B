package com.example.umc.mission.domain.mapping;

import com.example.umc.mission.domain.FoodCategory;
import com.example.umc.mission.domain.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PreferrenceofFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodCategory_id")
    private FoodCategory foodCategory;
}
