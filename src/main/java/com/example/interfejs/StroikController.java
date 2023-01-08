package com.example.interfejs;


import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class StroikController {

    private MediaPlayer mediaPlayer;

    public Button PowrotInstrumentyButton;


    public void Gtrzy() {
        String path =  getClass().getResource("/com/example/interfejs/zdjecia/Gtrzy.wav").getPath();
        System.out.println(path);
        File plik = new File(path);
        System.out.println(plik.exists());
        String uri = plik.toURI().toString();
        System.out.println(uri);
        Media hit = new Media(uri);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void PowrotInstrumenty() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Kategorie.fxml"));
        PowrotInstrumentyButton.getScene().setRoot(root);
    }

    public void Dcztery() {
        String path =  getClass().getResource("/com/example/interfejs/zdjecia/Dcztery.wav").getPath();
        System.out.println(path);
        File plik = new File(path);
        System.out.println(plik.exists());
        String uri = plik.toURI().toString();
        System.out.println(uri);
        Media hit = new Media(uri);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void Acztery() {
        String path =  getClass().getResource("/com/example/interfejs/zdjecia/Acztery.wav").getPath();
        System.out.println(path);
        File plik = new File(path);
        System.out.println(plik.exists());
        String uri = plik.toURI().toString();
        System.out.println(uri);
        Media hit = new Media(uri);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void Epiec() {
        String path =  getClass().getResource("/com/example/interfejs/zdjecia/Epiec.wav").getPath();
        System.out.println(path);
        File plik = new File(path);
        System.out.println(plik.exists());
        String uri = plik.toURI().toString();
        System.out.println(uri);
        Media hit = new Media(uri);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void Ctrzy() {
        String path =  getClass().getResource("/com/example/interfejs/zdjecia/Ctrzy.wav").getPath();
        System.out.println(path);
        File plik = new File(path);
        System.out.println(plik.exists());
        String uri = plik.toURI().toString();
        System.out.println(uri);
        Media hit = new Media(uri);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }


    public void Ejeden() {
        String path =  getClass().getResource("/com/example/interfejs/zdjecia/Ejeden.wav").getPath();
        System.out.println(path);
        File plik = new File(path);
        System.out.println(plik.exists());
        String uri = plik.toURI().toString();
        System.out.println(uri);
        Media hit = new Media(uri);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void Ajeden() {
        String path =  getClass().getResource("/com/example/interfejs/zdjecia/Ajeden.wav").getPath();
        System.out.println(path);
        File plik = new File(path);
        System.out.println(plik.exists());
        String uri = plik.toURI().toString();
        System.out.println(uri);
        Media hit = new Media(uri);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void Ddwa() {
        String path =  getClass().getResource("/com/example/interfejs/zdjecia/Ddwa.wav").getPath();
        System.out.println(path);
        File plik = new File(path);
        System.out.println(plik.exists());
        String uri = plik.toURI().toString();
        System.out.println(uri);
        Media hit = new Media(uri);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void Gdwa() {
        String path =  getClass().getResource("/com/example/interfejs/zdjecia/Gdwa.wav").getPath();
        System.out.println(path);
        File plik = new File(path);
        System.out.println(plik.exists());
        String uri = plik.toURI().toString();
        System.out.println(uri);
        Media hit = new Media(uri);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }


    public void Atrzy() {
        String path =  getClass().getResource("/com/example/interfejs/zdjecia/Atrzy.wav").getPath();
        System.out.println(path);
        File plik = new File(path);
        System.out.println(plik.exists());
        String uri = plik.toURI().toString();
        System.out.println(uri);
        Media hit = new Media(uri);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void Dtrzy() {
        String path =  getClass().getResource("/com/example/interfejs/zdjecia/Dtrzy.wav").getPath();
        System.out.println(path);
        File plik = new File(path);
        System.out.println(plik.exists());
        String uri = plik.toURI().toString();
        System.out.println(uri);
        Media hit = new Media(uri);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void Cdwa() {
        String path =  getClass().getResource("/com/example/interfejs/zdjecia/Cdwa.wav").getPath();
        System.out.println(path);
        File plik = new File(path);
        System.out.println(plik.exists());
        String uri = plik.toURI().toString();
        System.out.println(uri);
        Media hit = new Media(uri);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
}
