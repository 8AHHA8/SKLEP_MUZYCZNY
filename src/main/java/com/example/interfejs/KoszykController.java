package com.example.interfejs;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class KoszykController {

    public Button PowrotKoszykButton;

    public void PowrotKoszyk() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotKoszykButton.getScene().setRoot(root);
    }
}
