package by.itacademy.dao;

import by.itacademy.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

public class BaseDaoTest {

    public static  SessionFactory FACTORY;

    @BeforeClass
    public static void before(){
         FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Booking ").executeUpdate();
            session.createQuery("delete from User ").executeUpdate();
            session.createQuery("delete from Place ").executeUpdate();
            session.createQuery("delete from Role ").executeUpdate();
            session.createQuery("delete from TypePlace ").executeUpdate();
            session.createQuery("delete from Wagon ").executeUpdate();
            session.createQuery("delete from TimeTable ").executeUpdate();
            session.createQuery("delete from TypeWagon ").executeUpdate();
            session.createQuery("delete from Train ").executeUpdate();
            session.createQuery("delete from Station ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    public <T extends BaseEntity<?>> void save(T... object) {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();

            Arrays.asList(object).forEach(it -> {
                session.save(it);
                assertNotNull("Entity is not saved", it.getId());
            });

            session.getTransaction().commit();
        }
    }

    public <T extends BaseEntity<?>> void find(T... objects) {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();

            Arrays.asList(objects).forEach(it -> {
                session.save(it);
                assertNotNull("Entity is not saved", it.getId());

                session.evict(it);

                session.get(it.getClass(), it.getId());
                assertNotNull("Entity is null", it);
            });

            session.getTransaction().commit();
        }
    }
}
