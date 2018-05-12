package by.itacademy.dao;

import by.itacademy.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class EntityTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Test
    public void checkFindRole(){
        Role user = new Role("user");
        try (Session session = FACTORY.openSession()){
            Serializable userId = session.save(user);
            assertNotNull("id is null", userId);
        }
    }

       @Test
    public void checkFindTrain(){

    }

    @Test
    public void checkFindTypeWagon(){

    }

    @Test
    public void checkFindWagon(){

    }

    @Test
    public void checkFindTypePlace(){

    }

    @Test
    public void checkFindPlace(){

    }

    @Test
    public void checkFindUserData(){

    }

    @Test
    public void checkFindBooking(){

    }

    @Test
    public void checkFindStation(){

    }

    @Test
    public void checkFindTimeTable(){

    }
}
