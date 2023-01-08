package com.example.interfejs;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

import static com.example.interfejs.DBAccess.getEntityManager;

public class addKontrabasController {

    @FXML
    TextField nazwa;
    @FXML
    TextField drewno;
    @FXML
    TextField wysokosc;
    @FXML
    TextField cena;

    @FXML
    public Button PowrotKontrabasButton;

    @FXML
    public Button wyswietlformularzkontrabasButton;

    public void dodaj(ActionEvent actionEvent) {
        DBAccess.dodajKontrabas(new KontrabasHibernate(nazwa.getText(), drewno.getText(), Integer.parseInt(wysokosc.getText()), Integer.parseInt(cena.getText()), null));
    }

    public void PowrotKontrabas() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kontrabas.fxml"));
        PowrotKontrabasButton.getScene().setRoot(root);
    }

    @FXML
    private Button PowrotInstrumentyButton;

    @FXML
    private TableView<KontrabasHibernate> tableview;

    @FXML
    private TableColumn<KontrabasHibernate, String> idCol;

    @FXML
    private TableColumn<KontrabasHibernate, String> nazwaCol;

    @FXML
    private TableColumn<KontrabasHibernate, String> drewnoCol;

    @FXML
    private TableColumn<KontrabasHibernate, Integer> wysokoscCol;

    @FXML
    private TableColumn<KontrabasHibernate, Integer> cenaCol;

    @FXML
    private Button aktualizujButton;


    @FXML
    void PowrotInstrumenty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotInstrumentyButton.getScene().setRoot(root);
    }

    @FXML
    void aktualizujKontrabas(ActionEvent event) {
        zaladujTabele();
    }

    @FXML
    void wyswietlformularzkontrabas(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addKontrabas.fxml"));
        wyswietlformularzkontrabasButton.getScene().setRoot(root);
    }

    public void zaladujTabele() {
        tableview.getItems().clear();
        EntityManager entityManager = getEntityManager();
        String polecenie = "FROM KontrabasHibernate";
        Query query = (Query) entityManager.createQuery(polecenie);
        List<KontrabasHibernate> lista = query.list();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nazwaCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        drewnoCol.setCellValueFactory(new PropertyValueFactory<>("drewno"));
        wysokoscCol.setCellValueFactory(new PropertyValueFactory<>("wysokosc"));
        cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
        tableview.setItems(FXCollections.observableList(lista));


    }
}

