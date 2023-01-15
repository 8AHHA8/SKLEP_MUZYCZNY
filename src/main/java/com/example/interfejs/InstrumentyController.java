package com.example.interfejs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;
import org.hibernate.HibernateException;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.interfejs.DBAccess.*;

import com.example.interfejs.KlientHibernate;


public class InstrumentyController {

    @FXML
    public Button KoszykButton;

    public Button PracownikButton;

    public ToggleButton TloMuzyczneButton;


    private MediaPlayer mediaPlayer;

    public Button StrojenieButton;

    @FXML
    public Button wyswietlformularzinstrumentyButton;

    @FXML
    private TableView<InstrumentyHibernate> tableview;


    @FXML
    private TableColumn<InstrumentyHibernate, String> id_instrumentuCol;

    @FXML
    private TableColumn<InstrumentyHibernate, String> nazwaCol;

    @FXML
    private TableColumn<InstrumentyHibernate, String> drewnoCol;

    @FXML
    private TableColumn<InstrumentyHibernate, Integer> wiekCol;

    @FXML
    private TableColumn<InstrumentyHibernate, Integer> cenaCol;
    @FXML
    private TableColumn<InstrumentyHibernate, String> typCol;

    @FXML
    private TableColumn<InstrumentyHibernate, Void> removeCol;

    @FXML
    private TableColumn<InstrumentyHibernate, Void> edytujCol;

    @FXML
    private TableColumn<InstrumentyHibernate, Void> koszykCol;

    private ObservableList<InstrumentyHibernate> instrumentData;
    @FXML
    private TextField Search;


    public InstrumentyController() {
    }


    public void Koszyk(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Koszyk.fxml"));
        KoszykButton.getScene().setRoot(root);
    }

    public void Pracownik() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Zamowienia.fxml"));
        PracownikButton.getScene().setRoot(root);
    }

    public void TloMuzyczne() {

        if (TloMuzyczneButton.isSelected()) {
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
        } else {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
        }

    }


    public void Strojenie() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Strojenie.fxml"));
        StrojenieButton.getScene().setRoot(root);
    }


    @FXML
    void wyswietlformularzinstrumenty() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addInstrumenty.fxml"));
        wyswietlformularzinstrumentyButton.getScene().setRoot(root);
    }

    public void zaladujTabele() {
        tableview.getItems().clear();
        EntityManager entityManager = DBAccess.getEntityManager();
        try {

            entityManager.getTransaction().begin();

            String polecenie = "FROM InstrumentyHibernate ih";
            TypedQuery<InstrumentyHibernate> query = entityManager.createQuery(polecenie, InstrumentyHibernate.class);

            List<InstrumentyHibernate> lista = query.getResultList();

            id_instrumentuCol.setCellValueFactory(new PropertyValueFactory<>("ID_Instrumentu"));
            nazwaCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
            drewnoCol.setCellValueFactory(new PropertyValueFactory<>("drewno"));
            wiekCol.setCellValueFactory(new PropertyValueFactory<>("wiek"));
            cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
            typCol.setCellValueFactory(new PropertyValueFactory<>("typ"));

            tableview.setItems(FXCollections.observableList(lista));

            nazwaCol.setEditable(true);
            drewnoCol.setEditable(true);
            wiekCol.setEditable(true);
            cenaCol.setEditable(true);
            tableview.setEditable(true);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @FXML
    private void initialize() {

        zaladujTabele();

        removeCol.setCellFactory(param -> {
            Button removeButton = new Button("USUŃ");
            removeButton.setStyle("-fx-background-color: black");

            TableCell<InstrumentyHibernate, Void> cell = new TableCell<>();
            cell.setGraphic(removeButton);

            removeButton.setOnAction(event -> removeInstrumenty(cell.getIndex(), tableview));

            return cell;
        });



        edytujCol.setCellFactory(param -> {
            Button edytujButton = new Button("EDYTUJ");
            edytujButton.setStyle("-fx-background-color: black");

            TableCell<InstrumentyHibernate, Void> cell = new TableCell<>();
            cell.setGraphic(edytujButton);

            edytujButton.setOnAction(event -> edytujInstrumenty(cell.getIndex(), tableview));

            return cell;
        });


        Callback<TableColumn<InstrumentyHibernate, Integer>, TableCell<InstrumentyHibernate, Integer>> IntegerCellFactory
                = TextFieldTableCell.forTableColumn(new IntegerStringConverter());

        Callback<TableColumn<InstrumentyHibernate, String>, TableCell<InstrumentyHibernate, String>> StringCellFactory
                = TextFieldTableCell.forTableColumn();


        cenaCol.setCellFactory(col -> {
            TableCell<InstrumentyHibernate, Integer> cell = IntegerCellFactory.call(col);
            cell.setAlignment(Pos.CENTER_LEFT);
            return cell;
        });
        cenaCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<InstrumentyHibernate, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<InstrumentyHibernate, Integer> t) {
                ((InstrumentyHibernate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setCena(t.getNewValue());
            }
        });

        wiekCol.setCellFactory(col -> {
            TableCell<InstrumentyHibernate, Integer> cell = IntegerCellFactory.call(col);
            cell.setAlignment(Pos.CENTER_LEFT);
            return cell;
        });
        wiekCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<InstrumentyHibernate, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<InstrumentyHibernate, Integer> t) {
                ((InstrumentyHibernate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setWiek(t.getNewValue());
            }
        });

        nazwaCol.setCellFactory(col -> {
            TableCell<InstrumentyHibernate, String> cell = StringCellFactory.call(col);
            cell.setAlignment(Pos.CENTER_LEFT);
            return cell;
        });
        nazwaCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<InstrumentyHibernate, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<InstrumentyHibernate, String> t) {
                ((InstrumentyHibernate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setNazwa(t.getNewValue());
            }
        });

        drewnoCol.setCellFactory(col -> {
            TableCell<InstrumentyHibernate, String> cell = StringCellFactory.call(col);
            cell.setAlignment(Pos.CENTER_LEFT);
            return cell;
        });
        drewnoCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<InstrumentyHibernate, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<InstrumentyHibernate, String> t) {
                ((InstrumentyHibernate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setDrewno(t.getNewValue());
            }
        });

        typCol.setCellFactory(col -> {
            TableCell<InstrumentyHibernate, String> cell = StringCellFactory.call(col);
            cell.setAlignment(Pos.CENTER_LEFT);
            return cell;
        });
        typCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<InstrumentyHibernate, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<InstrumentyHibernate, String> t) {
                ((InstrumentyHibernate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setTyp(t.getNewValue());
            }
        });



        koszykCol.setCellFactory(param -> {
            Button koszykButton = new Button("KOSZYK");
            koszykButton.setStyle("-fx-background-color: black");

            TableCell<InstrumentyHibernate, Void> cell = new TableCell<>();
            cell.setGraphic(koszykButton);
            koszykButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    koszykInstrumenty(cell.getIndex(), tableview);
                    System.out.println(((Button) event.getSource()));
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Zakup.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());

                        ZakupController zakupController = fxmlLoader.getController();
                        zakupController.loadData(cell.getTableRow().getItem().ID_Instrumentu, cell.getTableRow().getItem().Cena);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initStyle(StageStyle.UTILITY);
                        stage.show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return cell;
        });



        EntityManager entityManager = DBAccess.getEntityManager();
        try {
            List<InstrumentyHibernate> instruments = entityManager.createQuery("FROM InstrumentyHibernate", InstrumentyHibernate.class).getResultList();
            instrumentData = FXCollections.observableArrayList(instruments);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        tableview.setItems(instrumentData);

        FilteredList<InstrumentyHibernate> filteredData = new FilteredList<>(instrumentData, p -> true);

        Search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(instrument -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(instrument.getID_Instrumentu()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (instrument.getNazwa().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (instrument.getDrewno().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(instrument.getWiek()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(instrument.getCena()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (instrument.getTyp().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<InstrumentyHibernate> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tableview.comparatorProperty());

        tableview.setItems(sortedData);

    }


}

