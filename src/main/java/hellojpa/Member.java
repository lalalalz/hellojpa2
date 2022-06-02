package hellojpa;

import hellojpa.Type.Address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private Address address;
}
