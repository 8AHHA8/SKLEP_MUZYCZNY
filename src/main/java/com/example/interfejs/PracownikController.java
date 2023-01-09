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

public class PracownikController {

    @FXML
    private Button PowrotPracownikButton;

    @FXML
    private TableView<PracownikHibernate> tableview;

    @FXML
    private TableColumn<PracownikHibernate, String> wlasnosc1Col;

    @FXML
    private TableColumn<PracownikHibernate, String> wlasnosc2Col;

    @FXML
    private TableColumn<PracownikHibernate, String> wlasnosc3Col;

    @FXML
    private TableColumn<PracownikHibernate, Integer> cenaCol;

    @FXML
    private TableColumn<PracownikHibernate, Integer> idCol;

    @FXML
    void PowrotPracownik() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotPracownikButton.getScene().setRoot(root);
    }

    @FXML
    void aktualizujKoszyk(ActionEvent event) {
        zaladujTabele();
    }

    public void zaladujTabele(){
        tableview.getItems().clear();
        EntityManager entityManager = getEntityManager();
        String polecenie = "FROM PracownikHibernate";
        Query query = (Query) entityManager.createQuery(polecenie);
        List<PracownikHibernate> lista = query.list();
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        wlasnosc1Col.setCellValueFactory(new PropertyValueFactory<>("wlasnosc1"));
        wlasnosc2Col.setCellValueFactory(new PropertyValueFactory<>("wlasnosc2"));
        wlasnosc3Col.setCellValueFactory(new PropertyValueFactory<>("wlasnosc3"));
        cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
        tableview.setItems(FXCollections.observableList(lista));


    }
}
