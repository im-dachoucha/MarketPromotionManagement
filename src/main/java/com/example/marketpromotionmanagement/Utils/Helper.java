package com.example.marketpromotionmanagement.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Consumer;

public class Helper {

    private final static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public static void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityManager em = entityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        } catch (Exception e) {
            e.getStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public static EntityManager entityManager() {
        return emf.createEntityManager();
    }
}
