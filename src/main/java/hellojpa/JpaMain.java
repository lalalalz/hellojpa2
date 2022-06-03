package hellojpa;

import hellojpa.Type.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        AddressHistory addressHistory1 = new AddressHistory();
        addressHistory1.setAddress(new Address("Seoul", "Gang-Nam", "1234"));

        AddressHistory addressHistory2 = new AddressHistory();
        addressHistory2.setAddress(new Address("Incheon", "Dong-InCheon", "2232"));

        Member member = new Member();
        member.getAddressHistories().add(addressHistory1);
        member.getAddressHistories().add(addressHistory2);

        entityManager.persist(member);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
