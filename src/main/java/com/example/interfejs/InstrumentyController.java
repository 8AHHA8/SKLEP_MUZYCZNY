package com.example.interfejs;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


import java.io.File;
import java.io.IOException;

public class InstrumentyController {
    public Button SkrzypceButton;

    public Button AltowkaButton;

    public Button WiolonczelaButton;

    public Button KontrabasButton;

    public Button KoszykButton;

    public Button PracownikButton;

    public ToggleButton TloMuzyczneButton;

    private MediaPlayer mediaPlayer;

    public Button StrojenieButton;



    public void Skrzypce() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Skrzypce.fxml"));
        SkrzypceButton.getScene().setRoot(root);
    }

    public void Altówka() throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("Altowki.fxml")));
        AltowkaButton.getScene().setRoot(root);
    }

    public void Wiolonczela() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Wiolonczela.fxml"));
        WiolonczelaButton.getScene().setRoot(root);
    }

    public void Kontrabas() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kontrabas.fxml"));
        KontrabasButton.getScene().setRoot(root);
    }

    public void Koszyk(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Koszyk.fxml"));
        KoszykButton.getScene().setRoot(root);
    }

    public void Pracownik() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Pracownik.fxml"));
        PracownikButton.getScene().setRoot(root);
    }

    public void TloMuzyczne() {

        if(TloMuzyczneButton.isSelected()){
            new Thread(new Task<>() {
                @Override
                protected Object call() throws Exception {

                    String path = getClass().getResource("/com/example/interfejs/Zdjecia/TloMuzyczne.mp3").getPath();
                    System.out.println(path);
                    File plik = new File(path);
                    System.out.println(plik.exists());
                    String uri = plik.toURI().toString();
                    System.out.println(uri);
                    Media hit = new Media(uri);
                    mediaPlayer = new MediaPlayer(hit);
                    mediaPlayer.setAutoPlay(true);
                    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                    mediaPlayer.setOnEndOfMedia(() -> {
                        mediaPlayer.seek(Duration.ZERO);
                        mediaPlayer.play();
                    });
                    return null;
                }
            }).start();
        }else{
            if(mediaPlayer != null){
                mediaPlayer.stop();
            }
        }


    }

    public void Strojenie() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Strojenie.fxml"));
        StrojenieButton.getScene().setRoot(root);
    }


}
