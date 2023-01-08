package com.example.interfejs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ekran extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(MenuGlowne(), 1000, 800);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public VBox MenuGlowne()
    {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        final Button cofnij = new Button("Wróć");
        final Button skrzypce = new Button("Skrzypce");
        final Button altowka = new Button("Altowka");
        final Button wioloczela = new Button("Wiolonczela");
        final Button kontrabas = new Button("Kontrabas");
        cofnij.setMaxWidth(400);
        cofnij.setMaxHeight(200);
        skrzypce.setMaxWidth(300);
        skrzypce.setMaxHeight(200);
        altowka.setMaxWidth(300);
        altowka.setMaxHeight(200);
        wioloczela.setMaxWidth(300);
        wioloczela.setMaxHeight(200);
        kontrabas.setMaxWidth(300);
        kontrabas.setMaxHeight(200);
        skrzypce.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                skrzypce.getScene().setRoot(Skrzypce());
            }
        });
        altowka.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                altowka.getScene().setRoot(Altowka());
            }
        });
        wioloczela.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                wioloczela.getScene().setRoot(Wiolonczela());
            }
        });
        kontrabas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                kontrabas.getScene().setRoot(Kontrabas());
            }
        });

        Text info = new Text("Wybór rodzaju instrumentu");
        Text greeting = new Text("Witamy w sklepie^^");
        vBox.getChildren().addAll(greeting, info, skrzypce, altowka, wioloczela, kontrabas);
        return vBox;
    }


    public VBox Skrzypce()
    {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        final Button button = new Button("Wróć");
        button.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent arg0) {
                button.getScene().setRoot(MenuGlowne());
            }
        });
        Text text = new Text("Wybierz skrzypce");
        vBox.getChildren().addAll(text, button);
        return vBox;
    }

    public VBox Altowka()
    {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        final Button button = new Button("Wróć");
        button.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent arg0) {
                button.getScene().setRoot(MenuGlowne());
            }
        });
        Text text = new Text("Wybierz Altówkę");
        vBox.getChildren().addAll(text, button);
        return vBox;
    }

    public VBox Wiolonczela()
    {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        final Button button = new Button("Wróć");
        button.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent arg0) {
                button.getScene().setRoot(MenuGlowne());
            }
        });
        Text text = new Text("Wybierz Wiolonczelę");
        vBox.getChildren().addAll(text, button);
        return vBox;
    }

    public VBox Kontrabas()
    {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        final Button button = new Button("Wróć");
        button.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent arg0) {
                button.getScene().setRoot(MenuGlowne());
            }
        });
        Text text = new Text("Wybierz Kontrabas");
        vBox.getChildren().addAll(text, button);
        return vBox;
    }

}