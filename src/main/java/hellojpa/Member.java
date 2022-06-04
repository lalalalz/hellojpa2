package hellojpa;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private Integer age;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressHistory> addressHistories = new ArrayList<>();

    // 연관관계 매핑 편의 메서드
    public void addOrder(Order order) {
        orders.add(order);
        order.setMember(this);
    }
}
