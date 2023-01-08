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



public class addSkrzypceController {

    @FXML
    TextField nazwa;
    @FXML
    TextField drewno;
    @FXML
    TextField wiek;
    @FXML
    TextField cena;

    @FXML
    public Button PowrotSkrzypceButton;
    @FXML
    public Button wyswietlformularzskrzypceButton;


    public void dodaj(ActionEvent actionEvent) {
        DBAccess.dodajSkrzypce(new SkrzypceHibernate(nazwa.getText(), drewno.getText(), Integer.parseInt(wiek.getText()), Integer.parseInt(cena.getText()), null));
    }

    public void PowrotSkrzypce() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Skrzypce.fxml"));
        PowrotSkrzypceButton.getScene().setRoot(root);
    }

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
    void wyswietlformularzskrzypce(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addSkrzypce.fxml"));
        wyswietlformularzskrzypceButton.getScene().setRoot(root);
    }

    public void zaladujTabele(){
        tableview.getItems().clear();
        EntityManager entityManager = getEntityManager();
        String polecenie = "FROM SkrzypceHibernate";
        Query query = (Query) entityManager.createQuery(polecenie);
        List<SkrzypceHibernate> lista = query.list();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nazwaCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        drewnoCol.setCellValueFactory(new PropertyValueFactory<>("drewno"));
        wiekCol.setCellValueFactory(new PropertyValueFactory<>("wiek"));
        cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
        tableview.setItems(FXCollections.observableList(lista));

    }

    private EntityManager entityManager;
    @FXML
    private void initialize() {
        removeCol.setCellFactory(param -> {
            Button removeButton = new Button("USUŃ");

            TableCell<SkrzypceHibernate, Void> cell = new TableCell<>();
            cell.setGraphic(removeButton);

            removeButton.setOnAction(event -> removeSkrzypce(cell.getIndex()));

            return cell;
        });
    }

    private void removeSkrzypce(int index) {
        SkrzypceHibernate skrzypceHibernate = tableview.getItems().get(index);
        tableview.getItems().remove(index);
        entityManager.getTransaction().begin();
        entityManager.remove(skrzypceHibernate);
        entityManager.getTransaction().commit();
    }


}
