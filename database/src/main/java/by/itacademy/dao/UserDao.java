package by.itacademy.dao;

import by.itacademy.entity.Buyer;
import by.itacademy.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BuyerDao {

    private static final BuyerDao INSTANCE = new BuyerDao();
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    public Buyer find() {
        Buyer buyer;
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();

            buyer = session.find(Buyer.class, 1L);

            session.getTransaction().commit();
        }

        return buyer;
    }

    public static BuyerDao getInstance() {
        return INSTANCE;
    }
}
