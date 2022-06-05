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


        Item item1 = new Item();
        item1.setName("콘칩");
        item1.setPrice(2000);
        item1.setQuantity(1);

        Item item2 = new Item();
        item2.setName("포카칩");
        item2.setPrice(2000);
        item2.setQuantity(2);

        Order order = new Order();
        order.addItem(item1);
        order.addItem(item2);

        entityManager.persist(order);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
