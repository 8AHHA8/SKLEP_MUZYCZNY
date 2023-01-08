package com.example.interfejs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class DBAccess {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projekt");
    private static EntityManager em = entityManagerFactory.createEntityManager();

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        return em;
    }
    public static void closeconn(){
        entityManagerFactory.close();
    }

    public static void dodajSkrzypce(SkrzypceHibernate skrzypceHibernate){
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(skrzypceHibernate);
        transaction.commit();
    }

    public static void dodajAltowka(AltowkaHibernate altowkaHibernate) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(altowkaHibernate);
        transaction.commit();
    }


    public static void dodajWiolonczela(WiolonczelaHibernate wiolonczelaHibernate) {
        try{
            EntityManager entityManager = getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(wiolonczelaHibernate);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void dodajKontrabas(KontrabasHibernate kontrabasHibernate) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(kontrabasHibernate);
        transaction.commit();
    }
}