package by.itacademy.dao;

import by.itacademy.manager.SessionFactoryManager;
import by.itacademy.util.ProjectTestDataImporter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;

public class BaseDaoTest {

    public static SessionFactory FACTORY = SessionFactoryManager.getSessionFactory();

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
            ProjectTestDataImporter.getInstance().importTestData(FACTORY);
        }
    }
}
