package com.example.interfejs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.interfejs.DBAccess.getEntityManager;


public class ZamowieniaController {

    @FXML
    private Button PowrotZamowieniaButton;

    @FXML
    private TextField Kasa;

    @FXML
    private Button ZatwierdzZakupButton;

    @FXML
    private TableView<ZamowieniaHibernate> tableviewZamowienia;

    @FXML
    private TableColumn<ZamowieniaHibernate, Integer> idCol;

    @FXML
    private TableColumn<ZamowieniaHibernate, LocalDateTime> dataCol;

    @FXML
    private TableColumn<ZamowieniaHibernate, Integer> id_instrumentuCol;

    @FXML
    private TableColumn<ZamowieniaHibernate, Integer> id_klientaCol;

    @FXML
    private TableColumn<ZamowieniaHibernate, Integer> cenaCol;
    @FXML
    private Button PobierzZamowieniaButton;

    @FXML
    private Button WyczyscKoszykButton;





    public void wczytywanieZamowienia() {
        tableviewZamowienia.getItems().clear();
        EntityManager entityManager = DBAccess.getEntityManager();
        try {
            entityManager.getTransaction().begin();

            String polecenie = "FROM ZamowieniaHibernate ih";
            TypedQuery<ZamowieniaHibernate> query = entityManager.createQuery(polecenie, ZamowieniaHibernate.class);

            List<ZamowieniaHibernate> lista = query.getResultList();

            idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
            dataCol.setCellValueFactory(new PropertyValueFactory<>("data_zamowienia"));
            id_instrumentuCol.setCellValueFactory(new PropertyValueFactory<>("ID_Instrumentu"));
            id_klientaCol.setCellValueFactory(new PropertyValueFactory<>("ID_Klienta"));
            cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));


            tableviewZamowienia.setItems(FXCollections.observableList(lista));

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @FXML
    public void initialize(){
        wczytywanieZamowienia();
    }


    @FXML
    void PowrotZamowienia() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotZamowieniaButton.getScene().setRoot(root);
    }
    DBAccess dbaccess = new DBAccess();

    public void PobierzZamowienia(ActionEvent actionEvent){
        ObservableList<KlientHibernate> zamowienia = FXCollections.observableArrayList();
        zamowienia.addAll(dbaccess.getKoszyk());
        System.out.println(zamowienia.get(0));
        ObservableList<ZamowieniaHibernate> magazyn = FXCollections.observableArrayList();
        for(int i = 0; i < zamowienia.size(); i++) {
           magazyn.add(new ZamowieniaHibernate(LocalDateTime.now(), zamowienia.get(i).Cena, zamowienia.get(i).getID_Instrumentu().ID_Instrumentu, zamowienia.get(i), i+1));
        }
        tableviewZamowienia.getItems().addAll(magazyn);
    }

    @FXML
    void ZatwierdzZakup() {
        double sum = 0.0;
        for (ZamowieniaHibernate order : tableviewZamowienia.getItems()) {
            sum += order.getCena();
        }
        Kasa.setText(Double.toString(sum));
        tableviewZamowienia.getItems().clear();
    }


    @FXML
    void WyczyscKoszyk() {
        dbaccess.usunKoszyk();
    }
}
