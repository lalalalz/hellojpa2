package hellojpa;

import hellojpa.Type.AddressType;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Address {

    @Id @GeneratedValue
    private Long id;

    @Embedded
    private List<AddressType> addresses;

}
