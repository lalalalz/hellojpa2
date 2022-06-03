package hellojpa;

import hellojpa.Type.Address;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AddressHistory {

    @Id @GeneratedValue
    private Long id;
    @Embedded
    private Address address;
}
