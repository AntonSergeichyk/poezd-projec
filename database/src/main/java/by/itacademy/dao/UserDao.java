package by.itacademy.dao;

import by.itacademy.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {

    private static final UserDao INSTANCE = new UserDao();
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    public User find() {
        User user;
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();

            user = session.find(User.class, 1L);

            session.getTransaction().commit();
        }

        return user;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
