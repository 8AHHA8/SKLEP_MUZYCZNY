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

public class addAltowkaController {

    @FXML
    TextField nazwa;
    @FXML
    TextField kolor;
    @FXML
    TextField wiek;
    @FXML
    TextField cena;

    @FXML
    public Button PowrotAltowkaButton;

    @FXML
    private Button wyswietlformularzaltowkaButton;


    public void dodaj(ActionEvent actionEvent) {
        DBAccess.dodajAltowka(new AltowkaHibernate(nazwa.getText(), kolor.getText(), Integer.parseInt(wiek.getText()), Integer.parseInt(cena.getText()), null));
    }
    public void PowrotAltowka() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Altowki.fxml"));
        PowrotAltowkaButton.getScene().setRoot(root);
    }

    @FXML
    private Button PowrotInstrumentyButton;

    @FXML
    private TableView<AltowkaHibernate> tableview;

    @FXML
    private TableColumn<AltowkaHibernate, String> idCol;

    @FXML
    private TableColumn<AltowkaHibernate, String> nazwaCol;

    @FXML
    private TableColumn<AltowkaHibernate, String> kolorCol;

    @FXML
    private TableColumn<AltowkaHibernate, Integer> wiekCol;

    @FXML
    private TableColumn<AltowkaHibernate, Integer> cenaCol;

    @FXML
    private Button aktualizujButton;

    @FXML
    void PowrotInstrumenty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotInstrumentyButton.getScene().setRoot(root);
    }

    @FXML
    public void aktualizujAltowka(ActionEvent actionEvent) {
        zaladujTabele();
    }

    @FXML
    void wyswietlformularzaltowka(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addAltowka.fxml"));
        wyswietlformularzaltowkaButton.getScene().setRoot(root);
    }

    public void zaladujTabele(){
        tableview.getItems().clear();
        EntityManager entityManager = getEntityManager();
        String polecenie = "FROM AltowkaHibernate";
        Query query = (Query) entityManager.createQuery(polecenie);
        List<AltowkaHibernate> lista = query.list();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nazwaCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        kolorCol.setCellValueFactory(new PropertyValueFactory<>("kolor"));
        wiekCol.setCellValueFactory(new PropertyValueFactory<>("wiek"));
        cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
        tableview.setItems(FXCollections.observableList(lista));

    }


}
