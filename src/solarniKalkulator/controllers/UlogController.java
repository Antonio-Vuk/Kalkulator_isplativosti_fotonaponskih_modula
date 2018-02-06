package solarniKalkulator.controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import solarniKalkulator.model.Kalkulator;

public class UlogController {
    ObservableList<Integer> brojmodulaliLista = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox broj_modulaField;

    @FXML
    private TextField cijenapomoduluField;

    @FXML
    private TextField dodatnaopremaField;

    @FXML
    private Spinner kamatnastopaField;

    @FXML
    private TextField cijenastrujeField;

    @FXML
    private TextField drzavnipoticajiField;

    @FXML
    private TextField godisnjapotrosnjaField;

    @FXML
    private CheckBox godisnjaBtn;

    @FXML
    private CheckBox mjesecnaBtn;

    @FXML
    private HBox mjeseciHbox;

    @FXML private  TextField sijecanjField;
    @FXML private  TextField veljacaField;
    @FXML private  TextField ozuljakField;
    @FXML private  TextField travanjField;
    @FXML private  TextField svibanjField;
    @FXML private  TextField lipanjField;
    @FXML private  TextField srpanjField;
    @FXML private  TextField kolovozField;
    @FXML private  TextField rujanField;
    @FXML private  TextField listopadField;
    @FXML private  TextField studeniField;
    @FXML private  TextField prosinacField;

    @FXML
    private void handlegodisnjaBox(){
        if (godisnjaBtn.isSelected()){
            mjesecnaBtn.setSelected(false);
        }
        godisnjapotrosnjaField.setDisable(false);
        mjesecnaBtn.setDisable(false);
        godisnjaBtn.setDisable(true);
        mjeseciHbox.setVisible(false);
        Kalkulator.Instance().getUlog().setMjeseciIndikator(false);
    }

    @FXML
    private void handlemjesecnaBox(){
        if (mjesecnaBtn.isSelected()){
            godisnjaBtn.setSelected(false);
        }
        godisnjapotrosnjaField.setDisable(true);
        mjesecnaBtn.setDisable(true);
        godisnjaBtn.setDisable(false);
        mjeseciHbox.setVisible(true);
        Kalkulator.Instance().getUlog().setMjeseciIndikator(true);
    }

    public Double provjera(String text, JFXTextField jfxTextField, Boolean b){
        Double broj;
        try{
            broj = Double.valueOf(text);
            return broj;
        }catch (NumberFormatException e){
            if(b){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Upozorenje");
                alert.setHeaderText("Morate unijeti broj");
                alert.setContentText("Niste unijeli brojčanu vrijednost!");
                alert.showAndWait();
                jfxTextField.setText("");
            }

        }
        return null;
    }

    @FXML
    private void initialize(){
        if (Kalkulator.Instance().getUlog().isMjeseciIndikator()){
            mjesecnaBtn.setDisable(true);
            mjesecnaBtn.setSelected(true);
            godisnjaBtn.setDisable(false);
            godisnjaBtn.setSelected(false);
            mjeseciHbox.setVisible(true);
        }
        SpinnerValueFactory<Integer> valueFactory =  new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        kamatnastopaField.setValueFactory(valueFactory);

        brojmodulaliLista.remove(0, brojmodulaliLista.size());
        int broj = Kalkulator.Instance().getLokacija().getPovrsinaKrova();
        if (broj > 0){
            for(int i = broj/8; i > 0; i--){
                brojmodulaliLista.add(i);
            }
            this.broj_modulaField.setItems(brojmodulaliLista);

            int povrsina = Kalkulator.Instance().getLokacija().getPovrsinaKrova();
            int br_mod = Kalkulator.Instance().getUlog().getBrojModula();

            if (br_mod == 0){
                this.broj_modulaField.setValue(brojmodulaliLista.get(0));
            }

            if (br_mod > povrsina / 8){
                this.broj_modulaField.setValue(brojmodulaliLista.get(0));
            }else{
                this.broj_modulaField.setValue(Kalkulator.Instance().getUlog().getBrojModula());
            }
        }

        broj_modulaField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Integer broj = Integer.valueOf(broj_modulaField.getValue().toString());
                Kalkulator.Instance().getUlog().setBrojModula(broj);
            }
        });
        cijenapomoduluField.setText(String.valueOf(Kalkulator.Instance().getUlog().getCijenaPoModulu()));
        dodatnaopremaField.setText(String.valueOf(Kalkulator.Instance().getUlog().getDodatnaOprema()));
        kamatnastopaField.getValueFactory().setValue(Kalkulator.Instance().getUlog().getKamatnaStopa());
        cijenastrujeField.setText(String.valueOf(Kalkulator.Instance().getUlog().getCijenaStruje()));
        drzavnipoticajiField.setText(String.valueOf(Kalkulator.Instance().getUlog().getDrzavniPoticaji()));
        godisnjapotrosnjaField.setText(String.valueOf(Kalkulator.Instance().getUlog().getGodisnjaPotrosnja()));

        sijecanjField.setText(String.valueOf(Kalkulator.Instance().getUlog().getMjeseci().getSijecanj()));
        veljacaField.setText(String.valueOf(Kalkulator.Instance().getUlog().getMjeseci().getVeljaca()));
        ozuljakField.setText(String.valueOf(Kalkulator.Instance().getUlog().getMjeseci().getOzuljak()));
        travanjField.setText(String.valueOf(Kalkulator.Instance().getUlog().getMjeseci().getTravanj()));
        svibanjField.setText(String.valueOf(Kalkulator.Instance().getUlog().getMjeseci().getSvibanj()));
        lipanjField.setText(String.valueOf(Kalkulator.Instance().getUlog().getMjeseci().getLipanj()));
        srpanjField.setText(String.valueOf(Kalkulator.Instance().getUlog().getMjeseci().getSrpanj()));
        kolovozField.setText(String.valueOf(Kalkulator.Instance().getUlog().getMjeseci().getKolovoz()));
        rujanField.setText(String.valueOf(Kalkulator.Instance().getUlog().getMjeseci().getRujan()));
        listopadField.setText(String.valueOf(Kalkulator.Instance().getUlog().getMjeseci().getListopad()));
        studeniField.setText(String.valueOf(Kalkulator.Instance().getUlog().getMjeseci().getStdeni()));
        prosinacField.setText(String.valueOf(Kalkulator.Instance().getUlog().getMjeseci().getProsinac()));

        cijenapomoduluField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(cijenapomoduluField.getText(), (JFXTextField) cijenapomoduluField, false) != null){
                        Kalkulator.Instance().getUlog().setCijenaPoModulu(provjera(cijenapomoduluField.getText(), (JFXTextField) cijenapomoduluField, false));
                    }else{
                        provjera(cijenapomoduluField.getText(), (JFXTextField) cijenapomoduluField, true);
                    }
                }
            }
        });

        dodatnaopremaField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(dodatnaopremaField.getText(), (JFXTextField) dodatnaopremaField, false) != null){
                        Kalkulator.Instance().getUlog().setDodatnaOprema(provjera(dodatnaopremaField.getText(), (JFXTextField) dodatnaopremaField, false));
                    }else{
                        provjera(dodatnaopremaField.getText(), (JFXTextField) dodatnaopremaField, true);
                    }
                }
            }
        });

        kamatnastopaField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    Kalkulator.Instance().getUlog().setKamatnaStopa(Integer.valueOf(kamatnastopaField.getValue().toString()));
                }
            }
        });
        cijenastrujeField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(cijenastrujeField.getText(), (JFXTextField) cijenastrujeField, false) != null){
                        Kalkulator.Instance().getUlog().setCijenaStruje(provjera(cijenastrujeField.getText(), (JFXTextField) cijenastrujeField, false));
                    }else{
                        provjera(cijenastrujeField.getText(), (JFXTextField) cijenastrujeField, true);
                    }
                }
            }
        });
        drzavnipoticajiField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(drzavnipoticajiField.getText(), (JFXTextField) drzavnipoticajiField, false) != null){
                        Kalkulator.Instance().getUlog().setDrzavniPoticaji(provjera(drzavnipoticajiField.getText(), (JFXTextField) drzavnipoticajiField, false));
                    }else{
                        provjera(drzavnipoticajiField.getText(), (JFXTextField) drzavnipoticajiField, true);
                    }
                }
            }
        });
        godisnjapotrosnjaField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(godisnjapotrosnjaField.getText(), (JFXTextField) godisnjapotrosnjaField, false) != null){
                        Kalkulator.Instance().getUlog().setGodisnjaPotrosnja(provjera(godisnjapotrosnjaField.getText(), (JFXTextField) godisnjapotrosnjaField, false));
                    }else{
                        provjera(godisnjapotrosnjaField.getText(), (JFXTextField) godisnjapotrosnjaField, true);
                    }
                }
            }
        });

        sijecanjField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(sijecanjField.getText(), (JFXTextField) sijecanjField, false) != null){
                        Kalkulator.Instance().getUlog().getMjeseci().setSijecanj(provjera(sijecanjField.getText(), (JFXTextField) sijecanjField, false));
                    }else{
                        provjera(sijecanjField.getText(), (JFXTextField) sijecanjField, true);
                    }
                }
            }
        });

        veljacaField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(veljacaField.getText(), (JFXTextField) veljacaField, false) != null){
                        Kalkulator.Instance().getUlog().getMjeseci().setVeljaca(provjera(veljacaField.getText(), (JFXTextField) veljacaField, false));
                    }else{
                        provjera(veljacaField.getText(), (JFXTextField) veljacaField, true);
                    }
                }
            }
        });

        ozuljakField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(ozuljakField.getText(), (JFXTextField) ozuljakField, false) != null){
                        Kalkulator.Instance().getUlog().getMjeseci().setOzuljak(provjera(ozuljakField.getText(), (JFXTextField) ozuljakField, false));
                    }else{
                        provjera(ozuljakField.getText(), (JFXTextField) ozuljakField, true);
                    }
                }
            }
        });

        travanjField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(travanjField.getText(), (JFXTextField) travanjField, false) != null){
                        Kalkulator.Instance().getUlog().getMjeseci().setTravanj(provjera(travanjField.getText(), (JFXTextField) travanjField, false));
                    }else{
                        provjera(travanjField.getText(), (JFXTextField) travanjField, true);
                    }
                }
            }
        });

        svibanjField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(svibanjField.getText(), (JFXTextField) svibanjField, false) != null){
                        Kalkulator.Instance().getUlog().getMjeseci().setSvibanj(provjera(svibanjField.getText(), (JFXTextField) svibanjField, false));
                    }else{
                        provjera(svibanjField.getText(), (JFXTextField) svibanjField, true);
                    }
                }
            }
        });
        lipanjField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(lipanjField.getText(), (JFXTextField) lipanjField, false) != null){
                        Kalkulator.Instance().getUlog().getMjeseci().setLipanj(provjera(lipanjField.getText(), (JFXTextField) lipanjField, false));
                    }else{
                        provjera(lipanjField.getText(), (JFXTextField) lipanjField, true);
                    }
                }
            }
        });


        srpanjField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(srpanjField.getText(), (JFXTextField) srpanjField, false) != null){
                        Kalkulator.Instance().getUlog().getMjeseci().setSrpanj(provjera(srpanjField.getText(), (JFXTextField) srpanjField, false));
                    }else{
                        provjera(srpanjField.getText(), (JFXTextField) srpanjField, true);
                    }
                }
            }
        });
        kolovozField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(kolovozField.getText(), (JFXTextField) kolovozField, false) != null){
                        Kalkulator.Instance().getUlog().getMjeseci().setKolovoz(provjera(kolovozField.getText(), (JFXTextField) kolovozField, false));
                    }else{
                        provjera(kolovozField.getText(), (JFXTextField) kolovozField, true);
                    }
                }
            }
        });
        rujanField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(rujanField.getText(), (JFXTextField) rujanField, false) != null){
                        Kalkulator.Instance().getUlog().getMjeseci().setRujan(provjera(rujanField.getText(), (JFXTextField) rujanField, false));
                    }else{
                        provjera(rujanField.getText(), (JFXTextField) rujanField, true);
                    }
                }
            }
        });

        listopadField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(listopadField.getText(), (JFXTextField) listopadField, false) != null){
                        Kalkulator.Instance().getUlog().getMjeseci().setListopad(provjera(listopadField.getText(), (JFXTextField) listopadField, false));
                    }else{
                        provjera(listopadField.getText(), (JFXTextField) listopadField, true);
                    }
                }
            }
        });
        studeniField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(studeniField.getText(), (JFXTextField) studeniField, false) != null){
                        Kalkulator.Instance().getUlog().getMjeseci().setStdeni(provjera(studeniField.getText(), (JFXTextField) studeniField, false));
                    }else{
                        provjera(studeniField.getText(), (JFXTextField) studeniField, true);
                    }
                }
            }
        });
        prosinacField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if (provjera(prosinacField.getText(), (JFXTextField) prosinacField, false) != null){
                        Kalkulator.Instance().getUlog().getMjeseci().setProsinac(provjera(prosinacField.getText(), (JFXTextField) prosinacField, false));
                    }else{
                        provjera(prosinacField.getText(), (JFXTextField) prosinacField, true);
                    }
                }
            }
        });
    }
}
