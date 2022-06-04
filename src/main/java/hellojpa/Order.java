package hellojpa;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "ORDRES")
public class Order {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    // 연관관계 매핑 편의 메서드
    public void addItem(Item item) {
        items.add(item);
        item.setOrder(this);
    }
}
