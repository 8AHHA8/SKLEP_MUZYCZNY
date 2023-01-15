package com.example.interfejs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogowanieController {

    @FXML
    private TextField LoginText;

    @FXML
    private PasswordField HasloText;

    @FXML
    private Button ZalogujButton;

    @FXML
    void Zaloguj(ActionEvent event) throws IOException {

        if (LoginText.getText().equals("Dominik") && (HasloText.getText().equals("Jachas123"))) {
            Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
            ZalogujButton.getScene().setRoot(root);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Olaboga!");
            alert.setHeaderText("Co to sie podzialo?");
            alert.setContentText("Versuchen Sie es nochmal!\nSpróbuj jeszcze raz. Należy wpisać poprawny Login i Hasło.");
            alert.showAndWait();
        }
    }

}
