package hellojpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private Integer price;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}