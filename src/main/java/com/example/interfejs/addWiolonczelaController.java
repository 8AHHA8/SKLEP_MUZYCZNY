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

public class addWiolonczelaController {

    @FXML
    TextField nazwa;
    @FXML
    TextField drewno;
    @FXML
    TextField waga;
    @FXML
    TextField cena;

    @FXML
    public Button PowrotWiolonczelaButton;

    @FXML
    public Button wyswietlformularzwiolonczelaButton;


    public void dodaj(ActionEvent actionEvent) {
        DBAccess.dodajWiolonczela(new WiolonczelaHibernate(nazwa.getText(), drewno.getText(), Integer.parseInt(waga.getText()), Integer.parseInt(cena.getText()), null));
    }
    public void PowrotWiolonczela() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Wiolonczela.fxml"));
        PowrotWiolonczelaButton.getScene().setRoot(root);
    }

    @FXML
    private Button PowrotInstrumentyButton;

    @FXML
    private TableView<WiolonczelaHibernate> tableview;

    @FXML
    private TableColumn<WiolonczelaHibernate, String> idCol;

    @FXML
    private TableColumn<WiolonczelaHibernate, String> nazwaCol;

    @FXML
    private TableColumn<WiolonczelaHibernate, String> drewnoCol;

    @FXML
    private TableColumn<WiolonczelaHibernate, Integer> wagaCol;

    @FXML
    private TableColumn<WiolonczelaHibernate, Integer> cenaCol;

    @FXML
    private Button aktualizujButton;

    @FXML
    void PowrotInstrumenty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotInstrumentyButton.getScene().setRoot(root);
    }

    public void aktualizujWiolonczela(ActionEvent actionEvent) {
        zaladujTabele();
    }

    @FXML
    void wyswietlformularzwiolonczela(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addWiolonczela.fxml"));
        wyswietlformularzwiolonczelaButton.getScene().setRoot(root);
    }

    public void zaladujTabele(){
        tableview.getItems().clear();
        EntityManager entityManager = getEntityManager();
        String polecenie = "FROM WiolonczelaHibernate";
        Query query = (Query) entityManager.createQuery(polecenie);
        List<WiolonczelaHibernate> lista = query.list();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nazwaCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        drewnoCol.setCellValueFactory(new PropertyValueFactory<>("drewno"));
        wagaCol.setCellValueFactory(new PropertyValueFactory<>("waga"));
        cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
        tableview.setItems(FXCollections.observableList(lista));

    }


}