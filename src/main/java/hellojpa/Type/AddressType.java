package hellojpa.Type;


import javax.persistence.Embeddable;

@Embeddable
public class AddressType {

    private String city;
    private String street;
    private String zipcode;

}
