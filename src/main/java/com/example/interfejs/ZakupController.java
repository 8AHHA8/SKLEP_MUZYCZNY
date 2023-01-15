package com.example.interfejs;

import javafx.fxml.FXML;
import javafx.scene.control.*;



public class ZakupController {

    @FXML
    Button zakupinstrumentuButton;
    @FXML
    TextField imieText;

    @FXML
    TextField nazwiskoText;

    @FXML
    TextField nr_telefonuText;

    @FXML
    Button zatwierdzButton;

    @FXML
    TextField id_instrumentuLabel;

    @FXML
    TextField cenaLabel;

    DBAccess dbAccess = new DBAccess();


    protected void loadData(int id_instrumentu, int cena) {
        cenaLabel.setText(Integer.toString(cena));
        id_instrumentuLabel.setText(Integer.toString(id_instrumentu));
    }


    public void zakupInstrumentu() {
        try {
            String nr_telefonu = nr_telefonuText.getText();
            Integer numer = Integer.parseInt(nr_telefonu);
            if ((nr_telefonuText.getText().matches("\\d+") && numer == 9)) {
                throw new NumberFormatException();
            }
            DBAccess.dodajZakup(new KlientHibernate(imieText.getText(), nazwiskoText.getText(), Integer.parseInt(nr_telefonu), dbAccess.getIdnstrument(Integer.parseInt(id_instrumentuLabel.getText())) , Integer.parseInt(cenaLabel.getText()) , null));
        } catch(NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Olaboga");
            alert.setHeaderText("Co to sie podzialo");
            alert.setContentText("Numer nie może być dłuższy niż 9 cyfr. Bis zum nächstes Mal!");
            alert.showAndWait();
        }




    }


}
