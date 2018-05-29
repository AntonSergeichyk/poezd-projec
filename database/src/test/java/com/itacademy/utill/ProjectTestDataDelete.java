package com.itacademy.util;

import com.itacademy.dao.impl.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectTestDataDelete {

    @Autowired
    private SessionFactory sessionFactory;

    public void deleteTestData(){
        try (Session session = sessionFactory.openSession()) {
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
}
