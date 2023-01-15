package com.example.interfejs;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class PowrotInstrumentyController {

    public Button PowrotInstrumentyButton;
    public void PowrotInstrumenty() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotInstrumentyButton.getScene().setRoot(root);
    }

    public void wyswietlformularzskrzypce() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addInstrumenty.fxml"));
        PowrotInstrumentyButton.getScene().setRoot(root);
    }

    public void wyswietlformularzaltowka() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addAltowka.fxml"));
        PowrotInstrumentyButton.getScene().setRoot(root);
    }

    public void wyswietlformularzwiolonczela() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addWiolonczela.fxml"));
        PowrotInstrumentyButton.getScene().setRoot(root);
    }

    public void wyswietlformularzkontrabas() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addKontrabas.fxml"));
        PowrotInstrumentyButton.getScene().setRoot(root);
    }
}
