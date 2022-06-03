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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressHistory> addressHistories = new ArrayList<>();
}
