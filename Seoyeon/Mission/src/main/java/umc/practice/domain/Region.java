package umc.practice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.practice.domain.common.BaseEntity;
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Region extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String regionName;

}
