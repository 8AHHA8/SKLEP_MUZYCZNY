package com.example.interfejs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

public class KoszykController {

    @FXML
    public Button PowrotKoszykButton;

    @FXML
    public TableView<KlientHibernate> tableviewklient;

    @FXML
    private TableColumn<KlientHibernate, Integer> id_klientaCol;

    @FXML
    private TableColumn<KlientHibernate, String> imieCol;

    @FXML
    private TableColumn<KlientHibernate, String> nazwiskoCol;

    @FXML
    private TableColumn<KlientHibernate, Integer> numer_telefonuCol;

    @FXML
    private TableColumn<InstrumentyHibernate, Integer> id_instrumentuCol;

    @FXML
    private TableColumn<InstrumentyHibernate, Integer> cenaCol;

    public ObservableList<KlientHibernate> getKlientItems() {
        return tableviewklient.getItems();
    }



    public void PowrotKoszyk() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotKoszykButton.getScene().setRoot(root);

    }


    public void wczytywanieKlienta() {
        tableviewklient.getItems().clear();
        EntityManager entityManager = DBAccess.getEntityManager();
        try {
            entityManager.getTransaction().begin();

            String polecenie = "FROM KlientHibernate ih";
            TypedQuery<KlientHibernate> query = entityManager.createQuery(polecenie, KlientHibernate.class);

            List<KlientHibernate> lista = query.getResultList();

            id_klientaCol.setCellValueFactory(new PropertyValueFactory<>("ID_Klienta"));
            imieCol.setCellValueFactory(new PropertyValueFactory<>("imie"));
            nazwiskoCol.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
            numer_telefonuCol.setCellValueFactory(new PropertyValueFactory<>("numer_Telefonu"));
            cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
            id_instrumentuCol.setCellValueFactory(new PropertyValueFactory<>("ID_Instrumentu"));

            tableviewklient.setItems(FXCollections.observableList(lista));

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @FXML
    public void initialize() {
        wczytywanieKlienta();
    }

}
