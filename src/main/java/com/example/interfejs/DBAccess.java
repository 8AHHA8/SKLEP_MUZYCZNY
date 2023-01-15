package com.example.interfejs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class DBAccess {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projekt");
    private static EntityManager em;

    public static EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }

    public static void closeconn() {
        entityManagerFactory.close();
    }


    public static void dodajInstrumenty(InstrumentyHibernate instrumentyHibernate) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(instrumentyHibernate);
        transaction.commit();
    }

    public static void removeInstrumenty(int index, TableView<InstrumentyHibernate> tableView) {
        EntityManager entityManager = getEntityManager();
        InstrumentyHibernate instrumentyHibernate = tableView.getItems().get(index);
        ObservableList<InstrumentyHibernate> newList = FXCollections.observableArrayList(tableView.getItems());
        newList.remove(index);
        tableView.setItems(newList);
        entityManager.getTransaction().begin();
        InstrumentyHibernate attachedInstrumentyHibernate = entityManager.merge(instrumentyHibernate);
        entityManager.remove(attachedInstrumentyHibernate);
        entityManager.getTransaction().commit();
    }

    public static void edytujInstrumenty(int index, TableView<InstrumentyHibernate> tableView) {
        EntityManager entityManager = getEntityManager();
        InstrumentyHibernate instrumentyHibernate = tableView.getItems().get(index);
        entityManager.getTransaction().begin();
        entityManager.merge(instrumentyHibernate);
        entityManager.getTransaction().commit();
        tableView.refresh();
    }

    public static void koszykInstrumenty(int index, TableView<InstrumentyHibernate> tableView) {
        EntityManager entityManager = getEntityManager();
        InstrumentyHibernate instrumentyHibernate = tableView.getItems().get(index);
        entityManager.getTransaction().begin();
        entityManager.merge(instrumentyHibernate);
        entityManager.getTransaction().commit();
        tableView.refresh();
    }

    public static void dodajZakup(KlientHibernate klientHibernate) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(klientHibernate);
        transaction.commit();
    }

    public InstrumentyHibernate getIdnstrument(int id_instrumentu) {
        Query query = em.createQuery("from InstrumentyHibernate r where  r.ID_Instrumentu = ?1");
        query.setParameter(1, id_instrumentu);
        return (InstrumentyHibernate) query.getSingleResult();
    }

    public InstrumentyHibernate getCena(int cena) {
        Query query = em.createQuery("from InstrumentyHibernate r where  r.Cena = ?1");
        query.setParameter(1, cena);
        return (InstrumentyHibernate) query.getSingleResult();
    }


    public List<KlientHibernate> getKoszyk() {
        em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("from KlientHibernate");
        return query.getResultList();
    }

    public List<KlientHibernate> usunKoszyk() {
        List<KlientHibernate> deletedRecords = new ArrayList<>();
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<KlientHibernate> query = entityManager.createQuery("SELECT k FROM KlientHibernate k", KlientHibernate.class);
        deletedRecords = query.getResultList();
        entityManager.createQuery("DELETE FROM KlientHibernate").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return deletedRecords;
    }

}


