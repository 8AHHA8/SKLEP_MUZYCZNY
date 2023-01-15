package com.example.interfejs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class dodajFormularzInstrumentyController {

    @FXML
    public Button PowrotInstrumentyButton;
    @FXML
    TextField nazwa;
    @FXML
    TextField drewno;
    @FXML
    TextField wiek;
    @FXML
    TextField cena;
    @FXML
    TextField typ;
    @FXML
    ComboBox<String>ComboboxWprowadzanie;



    private String[] types = {"Skrzypce", "Altowka", "Wiolonczela", "Kontrabas"};

    public void comboboxWprowadzanie() {
        List<String> listTypes = new ArrayList<>();
        for (String data : types) {
            listTypes.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listTypes);
        ComboboxWprowadzanie.setItems((listData));
    }

    @FXML
    private void initialize() {
        comboboxWprowadzanie();
    }


    public void dodaj() {
        if(ComboboxWprowadzanie.getValue() != null) {
            if(wiek.getText().matches("\\d+") || cena.getText().matches("\\d+"))
            DBAccess.dodajInstrumenty(new InstrumentyHibernate(nazwa.getText(), drewno.getText(), Integer.parseInt(wiek.getText()), Integer.parseInt(cena.getText()), ComboboxWprowadzanie.getValue(), null));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Olaboga!");
            alert.setHeaderText("Co to sie podzialo?");
            alert.setContentText("Nalezy wpisywac odpowiednie dane oraz wpisac typ instrumentu. Bis nächstes Mal!");
            alert.showAndWait();
        }
    }

    public void PowrotInstrumenty() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotInstrumentyButton.getScene().setRoot(root);
    }

}
