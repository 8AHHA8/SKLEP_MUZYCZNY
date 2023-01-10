package com.example.interfejs;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

import static com.example.interfejs.DBAccess.getEntityManager;
import static com.example.interfejs.DBAccess.removeAltowka;

public class addAltowkaController {

    @FXML
    private Button wyswietlformularzaltowkaButton;


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
    private TableColumn<AltowkaHibernate, Void> removeCol;

    @FXML
    private TableColumn<AltowkaHibernate, Void> edytujCol;

    @FXML
    private TableColumn<AltowkaHibernate, Void> koszykCol;

    @FXML
    private Button aktualizujButton;

    @FXML
    void PowrotInstrumenty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotInstrumentyButton.getScene().setRoot(root);
    }

    @FXML
    public void aktualizujAltowka() {
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
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nazwaCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        kolorCol.setCellValueFactory(new PropertyValueFactory<>("kolor"));
        wiekCol.setCellValueFactory(new PropertyValueFactory<>("wiek"));
        cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
        tableview.setItems(FXCollections.observableList(lista));

        nazwaCol.setEditable(true);
        kolorCol.setEditable(true);
        wiekCol.setEditable(true);
        cenaCol.setEditable(true);

        tableview.setEditable(true);

    }


    @FXML
    private void initialize() {

        removeCol.setCellFactory(param -> {
            Button removeButton = new Button("USUŃ");
            removeButton.setStyle("-fx-background-color: black");
            TableCell<AltowkaHibernate, Void> cell = new TableCell<>();
            cell.setGraphic(removeButton);

            removeButton.setOnAction(event -> removeAltowka(cell.getIndex(), tableview));

            return cell;
        });

//        edytujCol.setCellFactory(param -> {
//            Button edytujButton = new Button("EDYTUJ");
//            edytujButton.setStyle("-fx-background-color: black");
//
//            TableCell<AltowkaHibernate, Void> cell = new TableCell<>();
//            cell.setGraphic(edytujButton);
//
//            edytujButton.setOnAction(event -> removeAltowka(cell.getIndex(), tableview));
//
//            return cell;
//
//        });
//
//        koszykCol.setCellFactory(param -> {
//            Button koszykButton = new Button("KOSZYK");
//            koszykButton.setStyle("-fx-background-color: black");
//
//            TableCell<AltowkaHibernate, Void> cell = new TableCell<>();
//            cell.setGraphic(koszykButton);
//
//            koszykButton.setOnAction(event -> removeAltowka(cell.getIndex(), tableview));
//
//            return cell;
//
//        });

    }


}
