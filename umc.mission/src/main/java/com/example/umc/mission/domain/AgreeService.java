package com.example.umc.mission.domain;

import com.example.umc.mission.domain.mapping.Agreement;
import jakarta.persistence.*;
import lombok.*;

import javax.swing.table.TableCellEditor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AgreeService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String name;

    @OneToMany(mappedBy = "agreeService", cascade = CascadeType.ALL)
    private List<Agreement> agreementList = new ArrayList<>();


}
