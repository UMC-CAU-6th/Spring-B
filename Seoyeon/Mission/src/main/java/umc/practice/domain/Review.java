package umc.practice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.practice.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int stars;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="writer_id")
    private Member writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;

    public void setWriter(Member writer) {
        if(writer!=null)
            writer.getReviewList().remove(this);
        this.writer = writer;
        if(writer!=null)
            writer.getReviewList().add(this);
    }
    public void setStore(Store store) {
        if(store!=null)
            store.getReviewList().remove(this);
        this.store = store;
        if(store!=null)
            store.getReviewList().add(this);
    }

}
