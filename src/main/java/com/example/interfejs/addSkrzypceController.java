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
import static com.example.interfejs.DBAccess.removeSkrzypce;
import static com.example.interfejs.DBAccess.koszykSkrzypce;


public class addSkrzypceController {


    @FXML
    public Button wyswietlformularzskrzypceButton;

    @FXML
    private TableView<SkrzypceHibernate> tableview;
    @FXML
    private Button PowrotInstrumentyButton;

    @FXML
    private TableColumn<SkrzypceHibernate, String> idCol;

    @FXML
    private TableColumn<SkrzypceHibernate, String> nazwaCol;

    @FXML
    private TableColumn<SkrzypceHibernate, String> drewnoCol;

    @FXML
    private TableColumn<SkrzypceHibernate, Integer> wiekCol;

    @FXML
    private TableColumn<SkrzypceHibernate, Integer> cenaCol;

    @FXML
    private TableColumn<SkrzypceHibernate, Void> removeCol;

    @FXML
    private TableColumn<SkrzypceHibernate, Void> edytujCol;
    @FXML
    private TableColumn<SkrzypceHibernate, Void> koszykCol;

    @FXML
    private Button aktualizujButton;

    @FXML
    void PowrotInstrumenty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotInstrumentyButton.getScene().setRoot(root);
    }

    @FXML
    void aktualizujSkrzypce(ActionEvent event) {
        zaladujTabele();
    }

    @FXML
    void wyswietlformularzskrzypce() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addSkrzypce.fxml"));
        wyswietlformularzskrzypceButton.getScene().setRoot(root);
    }

    public void zaladujTabele(){
        tableview.getItems().clear();
        EntityManager entityManager = getEntityManager();
        String polecenie = "FROM SkrzypceHibernate";
        Query query = (Query) entityManager.createQuery(polecenie);
        List<SkrzypceHibernate> lista = query.list();
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nazwaCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        drewnoCol.setCellValueFactory(new PropertyValueFactory<>("drewno"));
        wiekCol.setCellValueFactory(new PropertyValueFactory<>("wiek"));
        cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
        tableview.setItems(FXCollections.observableList(lista));

        nazwaCol.setEditable(true);
        drewnoCol.setEditable(true);
        wiekCol.setEditable(true);
        cenaCol.setEditable(true);

        tableview.setEditable(true);

    }

    @FXML
    private void initialize() {

        removeCol.setCellFactory(param -> {
            Button removeButton = new Button("USUŃ");
            removeButton.setStyle("-fx-background-color: black");
            TableCell<SkrzypceHibernate, Void> cell = new TableCell<>();
            cell.setGraphic(removeButton);

            removeButton.setOnAction(event -> removeSkrzypce(cell.getIndex(), tableview));

            return cell;
        });

        edytujCol.setCellFactory(param -> {
            Button edytujButton = new Button("EDYTUJ");
            edytujButton.setStyle("-fx-background-color: black");

            TableCell<SkrzypceHibernate, Void> cell = new TableCell<>();
            cell.setGraphic(edytujButton);

            edytujButton.setOnAction(event -> removeSkrzypce(cell.getIndex(), tableview));

            return cell;

        });

        koszykCol.setCellFactory(param -> {
            Button koszykButton = new Button("KOSZYK");
            koszykButton.setStyle("-fx-background-color: black");

            TableCell<SkrzypceHibernate, Void> cell = new TableCell<>();
            cell.setGraphic(koszykButton);

            koszykButton.setOnAction(event -> removeSkrzypce(cell.getIndex(), tableview));

            return cell;

        });



    }




}
