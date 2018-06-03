package com.itacademy.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class TestDataDelete {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public TestDataDelete(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void deleteTestData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Booking ").executeUpdate();
        entityManager.createQuery("delete from User ").executeUpdate();
        entityManager.createQuery("delete from Place ").executeUpdate();
        entityManager.createQuery("delete from Role ").executeUpdate();
        entityManager.createQuery("delete from TypePlace ").executeUpdate();
        entityManager.createQuery("delete from Wagon ").executeUpdate();
        entityManager.createQuery("delete from TimeTable ").executeUpdate();
        entityManager.createQuery("delete from TypeWagon ").executeUpdate();
        entityManager.createQuery("delete from Train ").executeUpdate();
        entityManager.createQuery("delete from Station ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

