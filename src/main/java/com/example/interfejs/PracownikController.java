package com.example.interfejs;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class PracownikController {

    public Button PowrotPracownikButton;
    public void PowrotPracownik() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotPracownikButton.getScene().setRoot(root);
    }
}
