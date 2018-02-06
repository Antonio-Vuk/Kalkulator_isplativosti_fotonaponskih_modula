package solarniKalkulator.controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import solarniKalkulator.model.Kalkulator;

public class LokacijaController {

    ObservableList <String> gradoviLista = FXCollections.observableArrayList("Odaberite", "Gospić", "Varaždin", "Zagreb");
    ObservableList <String> nagibkrovaLista = FXCollections.observableArrayList("Odaberite", "45º", "60º", "75º");
    ObservableList <String> orijentacijaLista = FXCollections.observableArrayList("Odaberite", "jug", "jugoistok", "jugozapad", "istok", "zapad");
    ObservableList <String> moduliLista = FXCollections.observableArrayList("Odaberite", "fotonaponski modul SV 215");
    ObservableList <Integer> brojmodulaliLista = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox gradField;

    @FXML
    private ChoiceBox nagibkrovaField;

    @FXML
    private ChoiceBox orijentacijaField;

    @FXML
    private JFXTextField povrsinakrovaField;

    @FXML
    private ChoiceBox vrstamodulaField;

    @FXML
    private void initialize(){
        gradField.setItems(gradoviLista);
        nagibkrovaField.setItems(nagibkrovaLista);
        orijentacijaField.setItems(orijentacijaLista);
        vrstamodulaField.setItems(moduliLista);

        if (Kalkulator.Instance().getLokacija().getGrad() != null){
            gradField.setValue(Kalkulator.Instance().getLokacija().getGrad());
        }else{
            gradField.setValue("Odaberite");
        }

        if (Kalkulator.Instance().getLokacija().getNagibKrova() != 0) {
            nagibkrovaField.setValue(String.valueOf(Kalkulator.Instance().getLokacija().getNagibKrova()) + "º");
        } else {
            nagibkrovaField.setValue("Odaberite");
        }

        if(Kalkulator.Instance().getLokacija().getOrijentacija() != null){
            orijentacijaField.setValue(Kalkulator.Instance().getLokacija().getOrijentacija());
        }else {
            orijentacijaField.setValue("Odaberite");
        }

        if (Kalkulator.Instance().getLokacija().getPovrsinaKrova() != 0){
            povrsinakrovaField.setText(String.valueOf(Kalkulator.Instance().getLokacija().getPovrsinaKrova()));
        }

        if (Kalkulator.Instance().getLokacija().getVrstaModula() != null){
            vrstamodulaField.setValue(Kalkulator.Instance().getLokacija().getVrstaModula());
        }else{
            vrstamodulaField.setValue("Odaberite");
        }

        gradField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!gradField.getValue().toString().equalsIgnoreCase("Odaberite")){
                    Kalkulator.Instance().getLokacija().setGrad(gradField.getValue().toString());
                }else{
                    Kalkulator.Instance().getLokacija().setGrad(null);
                }
            }
        });

        nagibkrovaField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!nagibkrovaField.getValue().toString().equalsIgnoreCase("Odaberite")){
                    int lenght = nagibkrovaField.getValue().toString().length();
                    int pozicija = lenght - 1;
                    String store = new String("");
                    if(lenght > 0){
                        StringBuilder stringBuilder = new StringBuilder(nagibkrovaField.getValue().toString());
                        stringBuilder.deleteCharAt(pozicija);
                        store = stringBuilder.toString();
                    }
                    int Vrijednost = Integer.valueOf(store);
                    Kalkulator.Instance().getLokacija().setNagibKrova(Vrijednost);
                }else{
                    Kalkulator.Instance().getLokacija().setNagibKrova(0);
                }
            }
        });

        orijentacijaField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!orijentacijaField.getValue().toString().equalsIgnoreCase("Odaberite")){
                    Kalkulator.Instance().getLokacija().setOrijentacija(orijentacijaField.getValue().toString());
                }else{
                    Kalkulator.Instance().getLokacija().setOrijentacija(null);
                }
            }
        });

        vrstamodulaField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(vrstamodulaField.getValue().toString().equalsIgnoreCase("fotonaponski modul SV 215")){
                    Kalkulator.Instance().getLokacija().setVrstaModula(vrstamodulaField.getValue().toString());
                }else{
                    Kalkulator.Instance().getLokacija().setVrstaModula(null);
                }
            }
        });

        povrsinakrovaField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                int broj = 0;
                if (newValue){

                }else {
                    try {
                        broj = Integer.valueOf(povrsinakrovaField.getText());
                    }catch (NumberFormatException e){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Upozorenje");
                        alert.setHeaderText("Morate unijeti broj");
                        alert.setContentText("Niste unijeli brojčanu vrijednost!");
                        alert.showAndWait();
                        povrsinakrovaField.setText("");
                        Kalkulator.Instance().getLokacija().setPovrsinaKrova(0);
                    }
                    Kalkulator.Instance().getLokacija().setPovrsinaKrova(broj);
                }
            }
        });
    }
}
