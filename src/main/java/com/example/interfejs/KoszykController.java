package com.example.interfejs;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

import static com.example.interfejs.DBAccess.getEntityManager;

public class KoszykController {

    @FXML
    private Button PowrotKoszykButton;

    @FXML
    private TableView<KoszykHibernate> tableview;

    @FXML
    private TableColumn<KoszykHibernate, String> wlasnosc1Col;

    @FXML
    private TableColumn<KoszykHibernate, String> wlasnosc2Col;

    @FXML
    private TableColumn<KoszykHibernate, String> wlasnosc3Col;

    @FXML
    private TableColumn<KoszykHibernate, Integer> cenaCol;

    @FXML
    private TableColumn<KoszykHibernate, Integer> idCol;

    @FXML
    void PowrotKoszyk() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotKoszykButton.getScene().setRoot(root);
    }

    @FXML
    void aktualizujKoszyk(ActionEvent event) {
        zaladujTabele();
    }

    public void zaladujTabele(){
        tableview.getItems().clear();
        EntityManager entityManager = getEntityManager();
        String polecenie = "FROM KoszykHibernate";
        Query query = (Query) entityManager.createQuery(polecenie);
        List<KoszykHibernate> lista = query.list();
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        wlasnosc1Col.setCellValueFactory(new PropertyValueFactory<>("wlasnosc1"));
        wlasnosc2Col.setCellValueFactory(new PropertyValueFactory<>("wlasnosc2"));
        wlasnosc3Col.setCellValueFactory(new PropertyValueFactory<>("wlasnosc3"));
        cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
        tableview.setItems(FXCollections.observableList(lista));


    }
}
