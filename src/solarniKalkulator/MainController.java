package solarniKalkulator;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import solarniKalkulator.model.Kalkulator;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable{

    public VBox ulogGUI = new VBox();
    public ScrollPane mainContent;

    ArrayList <Integer> polje = new ArrayList<Integer>(3);
    boolean indikator = false;

    @FXML private JFXButton button1;
    @FXML private JFXButton button2;
    @FXML private JFXButton button3;

    @FXML
    private AnchorPane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        polje.add(1);
        polje.add(0);
        polje.add(0);
        povecaj(button1, 0.5);
        if (!Main.isSplashLoaded) {
            loadSplashScreen();
        }
    }

    private void loadSplashScreen() {

        try {
            Main.isSplashLoaded = true;

            StackPane pane = FXMLLoader.load(getClass().getResource(("fxmls/splashScreenGUI.fxml")));
            root.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

            fadeOut.setOnFinished((e) -> {
                try {
                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("fxmls/mainGUI.fxml")));
                    root.getChildren().setAll(parentContent);

                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void povecaj(JFXButton button, double trajanje){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(trajanje), button);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);


        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(trajanje));
        translateTransition.setNode(button);

        translateTransition.setToY(0);
        translateTransition.setByX(5);

        ParallelTransition parallelTransition = new ParallelTransition(scaleTransition, translateTransition);
        parallelTransition.play();
    }
    public void smanji(JFXButton button, double trajanje){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(trajanje), button);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(trajanje));
        translateTransition.setNode(button);

        translateTransition.setToY(0);
        translateTransition.setByX(-5);

        ParallelTransition parallelTransition = new ParallelTransition(scaleTransition, translateTransition);
        parallelTransition.play();
    }

    Integer get_indeks(ArrayList <Integer> lista){
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i) > 0){
                return i+1;
            }
        }
        return 0;
    }

    JFXButton dohvati(int broj){
        if (broj == 1){
            return button1;
        }
        if (broj == 2){
            return button2;
        }
        return button3;
    }

    public void animatebutton1() throws IOException {

        ulogGUI.getChildren().clear();
        ulogGUI.getChildren().add(FXMLLoader.load(getClass().getResource("fxmls/lokacijaGUI.fxml")));
        mainContent.setContent(ulogGUI);

        if (polje.get(0).equals(1)){
            return;
        }
        if (get_indeks(polje).equals(0) ){
            polje.set(0, 1);
            povecaj(button1, 0.5);
            return;
        }
        if (get_indeks(polje) > 0){
            int indeks = get_indeks(polje);
            smanji(dohvati(indeks),0.5);
            polje.set(indeks-1, 0);
            polje.set(0, 1);
            povecaj(button1, 0.5);
        }
    }

    public void animatebutton2() throws IOException {

        ulogGUI.getChildren().clear();
        ulogGUI.getChildren().add(FXMLLoader.load(getClass().getResource("fxmls/ulogGUI.fxml")));
        mainContent.setContent(ulogGUI);

        if (polje.get(1).equals(1)){
            return;
        }
        if (get_indeks(polje).equals(0) ){
            polje.set(1, 1);
            povecaj(button2, 0.5);
            return;
        }
        if (get_indeks(polje) > 0){
            int indeks = get_indeks(polje);
            smanji(dohvati(indeks),0.5);
            polje.set(indeks-1, 0);
            polje.set(1, 1);
            povecaj(button2, 0.5);
        }
    }

    public void animatebutton3() throws IOException {
        if (Kalkulator.Instance().getLokacija().isIndikatorGreske()){
            ulogGUI.getChildren().clear();
            ulogGUI.getChildren().add(FXMLLoader.load(getClass().getResource("fxmls/greskaGUI.fxml")));
            mainContent.setContent(ulogGUI);
        }else {
            ulogGUI.getChildren().clear();
            ulogGUI.getChildren().add(FXMLLoader.load(getClass().getResource("fxmls/izracunGUI.fxml")));
            mainContent.setContent(ulogGUI);
        }


        if (polje.get(2).equals(1)){
            return;
        }
        if (get_indeks(polje).equals(0) ){
            polje.set(2, 1);
            povecaj(button3, 0.5);
            return;
        }
        if (get_indeks(polje) > 0){
            int indeks = get_indeks(polje);
            smanji(dohvati(indeks),0.5);
            polje.set(indeks-1, 0);
            polje.set(2, 1);
            povecaj(button3, 0.5);
        }
    }
}
