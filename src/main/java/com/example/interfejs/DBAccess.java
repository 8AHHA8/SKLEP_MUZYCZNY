package com.example.interfejs;

import javafx.scene.control.TableView;

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
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(wiolonczelaHibernate);
        transaction.commit();
    }

    public static void dodajKontrabas(KontrabasHibernate kontrabasHibernate) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(kontrabasHibernate);
        transaction.commit();
    }

    public static void removeSkrzypce(int index, TableView<SkrzypceHibernate> tableView) {
        EntityManager entityManager = getEntityManager();
        SkrzypceHibernate skrzypceHibernate = tableView.getItems().get(index);
        tableView.getItems().remove(index);
        entityManager.getTransaction().begin();
        entityManager.remove(skrzypceHibernate);
        entityManager.getTransaction().commit();
    }

    public static void edytujSkrzypce(int index, TableView<SkrzypceHibernate> tableView) {
        EntityManager entityManager = getEntityManager();
        SkrzypceHibernate skrzypceHibernate = tableView.getItems().get(index);
        tableView.getItems().remove(index);
        entityManager.getTransaction().begin();
        entityManager.remove(skrzypceHibernate);
        entityManager.getTransaction().commit();
    }

    public static void koszykSkrzypce(int index, TableView<SkrzypceHibernate> tableView) {
        EntityManager entityManager = getEntityManager();
        SkrzypceHibernate skrzypceHibernate = tableView.getItems().get(index);
        tableView.getItems().remove(index);
        entityManager.getTransaction().begin();
        entityManager.remove(skrzypceHibernate);
        entityManager.getTransaction().commit();
    }

    public static void removeAltowka(int index, TableView<AltowkaHibernate> tableView) {
        EntityManager entityManager = getEntityManager();
        AltowkaHibernate altowkaHibernate = tableView.getItems().get(index);
        tableView.getItems().remove(index);
        entityManager.getTransaction().begin();
        entityManager.remove(altowkaHibernate);
        entityManager.getTransaction().commit();
    }

    public static void edytujAltowka(int index, TableView<AltowkaHibernate> tableView) {
        EntityManager entityManager = getEntityManager();
        AltowkaHibernate altowkaHibernate = tableView.getItems().get(index);
        tableView.getItems().remove(index);
        entityManager.getTransaction().begin();
        entityManager.remove(altowkaHibernate);
        entityManager.getTransaction().commit();
    }

    public static void koszykAltowka(int index, TableView<AltowkaHibernate> tableView) {
        EntityManager entityManager = getEntityManager();
        AltowkaHibernate altowkaHibernate = tableView.getItems().get(index);
        tableView.getItems().remove(index);
        entityManager.getTransaction().begin();
        entityManager.remove(altowkaHibernate);
        entityManager.getTransaction().commit();
    }


}