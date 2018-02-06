package solarniKalkulator.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import solarniKalkulator.model.Kalkulator;

public class GreskaController {

    @FXML
    private Label gradgreskaLabel;

    @FXML
    private Label nagibgreskaLabel;

    @FXML
    private Label orijentacijagreskaLabel;

    @FXML
    private Label povrsinagreskaLabel;

    @FXML
    private Label modulgreskaLabel;

    @FXML
    private VBox vboxgreske;

    @FXML
    public void initialize(){
        pokreni();
    }

    @FXML
    private void pokreni(){
        ObservableList<Node> lista = vboxgreske.getChildren();

        if (Kalkulator.Instance().getLokacija().getGrad() == null){
            if(!lista.contains(gradgreskaLabel)){
                lista.add(gradgreskaLabel);
            }
        }else{
            lista.remove(gradgreskaLabel);
        }

        if (Kalkulator.Instance().getLokacija().getNagibKrova() == 0){
            if(!lista.contains(nagibgreskaLabel)){
                lista.add(nagibgreskaLabel);
            }
        }else{
            lista.remove(nagibgreskaLabel);
        }

        if (Kalkulator.Instance().getLokacija().getOrijentacija() == null){
            if(!lista.contains(orijentacijagreskaLabel)){
                lista.add(orijentacijagreskaLabel);
            }
        }else{
            lista.remove(orijentacijagreskaLabel);
        }

        if (Kalkulator.Instance().getLokacija().getPovrsinaKrova() == 0){
            if(!lista.contains(povrsinagreskaLabel)){
                lista.add(povrsinagreskaLabel);
            }
        }else{
            lista.remove(povrsinagreskaLabel);
        }

        if (Kalkulator.Instance().getLokacija().getVrstaModula() == null){
            if(!lista.contains(modulgreskaLabel)){
                lista.add(modulgreskaLabel);
            }
        }else{
            lista.remove(modulgreskaLabel);
        }
    }
}
