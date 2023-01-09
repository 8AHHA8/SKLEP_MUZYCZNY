package com.example.interfejs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class dodajFormularzSkrzypceController {

    @FXML
    public Button PowrotSkrzypceButton;

    public void dodaj() {
        DBAccess.dodajSkrzypce(new SkrzypceHibernate(nazwa.getText(), drewno.getText(), Integer.parseInt(wiek.getText()), Integer.parseInt(cena.getText()), null));
    }

    public void PowrotSkrzypce() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Skrzypce.fxml"));
        PowrotSkrzypceButton.getScene().setRoot(root);
    }

    @FXML
    TextField nazwa;
    @FXML
    TextField drewno;
    @FXML
    TextField wiek;
    @FXML
    TextField cena;

}
