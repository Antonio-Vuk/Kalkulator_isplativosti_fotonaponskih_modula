package solarniKalkulator.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import solarniKalkulator.model.Kalkulator;
import solarniKalkulator.model.TableRow;

public class IzracunController {
    @FXML
    public TableView izracunTable;

    @FXML
    public Label dobiciodpoticajaLabel;

    @FXML
    public Label cijenaugradnjeLabel;

    @FXML
    public Label izdacizastrujuLabel;

    @FXML
    public Label ukupnoLabel;

    @FXML
    public Label brojpotrebnihmodula;

    @FXML
    public Label dobiciodpoticajaLabel2;

    @FXML
    public Label cijenaugradnjeLabel2;

    @FXML
    public Label izdacizastrujuLabel2;

    @FXML
    public Label ukupnoLabel2;

    @FXML
    public void initialize(){
        Kalkulator.Instance().getIzracun().loadData();

        TableColumn<TableRow, String> Column = new TableColumn<>("Mjesec");
        Column.setPrefWidth(115);
        Column.setCellValueFactory(new PropertyValueFactory<>("nazivMjeseca"));

        TableColumn<TableRow, Double> Column1 = new TableColumn<>("proizvodnja po 1kW");
        Column1.setPrefWidth(135);
        Column1.setCellValueFactory(new PropertyValueFactory<>("proizvodnjaPo1kW"));

        TableColumn<TableRow, Double> Column2 = new TableColumn<>("dobivena energija");
        Column2.setPrefWidth(120);
        Column2.setCellValueFactory(new PropertyValueFactory<>("dobivenaEnergija"));

        TableColumn<TableRow, Double> Column3 = new TableColumn<>("utrošena energija");
        Column3.setPrefWidth(120);
        Column3.setCellValueFactory(new PropertyValueFactory<>("utrosenaEnergija"));

        TableColumn<TableRow, Double> Column4 = new TableColumn<>("razlika");
        Column4.setPrefWidth(117);
        Column4.setCellValueFactory(new PropertyValueFactory<>("razlika"));

        izracunTable.setItems(getRows());
        izracunTable.getColumns().addAll(Column, Column1, Column2, Column3, Column4);

        dobiciodpoticajaLabel.setText(String.valueOf(
                Kalkulator.Instance().getIzracun().getIzracun1().getDobiciOdPoticaja())
        );

        cijenaugradnjeLabel.setText("-"+String.valueOf(
                Kalkulator.Instance().getIzracun().getIzracun1().getCijenaUgradnje())
        );

        izdacizastrujuLabel.setText("-"+String.valueOf(
                Kalkulator.Instance().getIzracun().getIzracun1().getIzdaciZaStruju())
        );

        ukupnoLabel.setText(String.valueOf(
                Kalkulator.Instance().getIzracun().getIzracun1().getUkupno())
        );

        brojpotrebnihmodula.setText(String.valueOf(Kalkulator.Instance().getIzracun().getMinBrojPotrebnihModula()));

        dobiciodpoticajaLabel2.setText(String.valueOf(
                Kalkulator.Instance().getIzracun().getIzracun2().getDobiciOdPoticaja())
        );

        cijenaugradnjeLabel2.setText("-"+String.valueOf(
                Kalkulator.Instance().getIzracun().getIzracun2().getCijenaUgradnje())
        );

        izdacizastrujuLabel2.setText("-"+String.valueOf(
                Kalkulator.Instance().getIzracun().getIzracun2().getIzdaciZaStruju())
        );

        ukupnoLabel2.setText(String.valueOf(
                Kalkulator.Instance().getIzracun().getIzracun2().getUkupno())
        );
    }


    public ObservableList<TableRow> getRows(){
        ObservableList<TableRow> redci = FXCollections.observableArrayList();
        for (int i = 0; i < Kalkulator.Instance().getIzracun().getProizvodnjaPo1KwLista().size(); i++){
            redci.add(new TableRow(
                    Kalkulator.Instance().getIzracun().getListaMjeseci().get(i),
                    Kalkulator.Instance().getIzracun().getProizvodnjaPo1KwLista().get(i),
                    Kalkulator.Instance().getIzracun().getDobivenaEnergijaLista().get(i),
                    Kalkulator.Instance().getIzracun().getUtrosenaEnergijaLista().get(i),
                    Kalkulator.Instance().getIzracun().getRazlikaLista().get(i)
            ));
        }

        TableRow redakUkupno = new TableRow(
                "UKUPNO:",
                Kalkulator.Instance().getIzracun().ukupniZbrojListe(
                        Kalkulator.Instance().getIzracun().getProizvodnjaPo1KwLista()
                ),
                Kalkulator.Instance().getIzracun().ukupniZbrojListe(
                        Kalkulator.Instance().getIzracun().getDobivenaEnergijaLista()
                ),
                Kalkulator.Instance().getIzracun().ukupniZbrojListe(
                        Kalkulator.Instance().getIzracun().getUtrosenaEnergijaLista()
                ),
                Kalkulator.Instance().getIzracun().ukupniZbrojListe(
                        Kalkulator.Instance().getIzracun().getRazlikaLista()
                )
        );
        redci.add(redakUkupno);
        return redci;
    }
}
