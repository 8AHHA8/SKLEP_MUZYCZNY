package com.example.interfejs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class dodajFormularzAltowkaController {

    @FXML
    public Button PowrotAltowkaButton;

    public void dodaj() {
        DBAccess.dodajAltowka(new AltowkaHibernate(nazwa.getText(), kolor.getText(), Integer.parseInt(wiek.getText()), Integer.parseInt(cena.getText()), null));
    }

    public void PowrotAltowka() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Altowki.fxml"));
        PowrotAltowkaButton.getScene().setRoot(root);
    }

    @FXML
    TextField nazwa;
    @FXML
    TextField kolor;
    @FXML
    TextField wiek;
    @FXML
    TextField cena;
}
