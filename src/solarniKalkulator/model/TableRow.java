package solarniKalkulator.model;

public class TableRow {
    private String nazivMjeseca;
    private double proizvodnjaPo1kW;
    private double dobivenaEnergija;
    private double utrosenaEnergija;
    private double razlika;

    public TableRow(String nazivMjeseca, double proizvodnjaPo1kW, double dobivenaEnergija, double utrosenaEnergija, double razlika) {
        this.nazivMjeseca = nazivMjeseca;
        this.proizvodnjaPo1kW = proizvodnjaPo1kW;
        this.dobivenaEnergija = dobivenaEnergija;
        this.utrosenaEnergija = utrosenaEnergija;
        this.razlika = razlika;
    }

    public TableRow() {
    }

    public String getNazivMjeseca() {
        return nazivMjeseca;
    }

    public void setNazivMjeseca(String nazivMjeseca) {
        this.nazivMjeseca = nazivMjeseca;
    }

    public double getProizvodnjaPo1kW() {
        return proizvodnjaPo1kW;
    }

    public void setProizvodnjaPo1kW(double proizvodnjaPo1kW) {
        this.proizvodnjaPo1kW = proizvodnjaPo1kW;
    }

    public double getDobivenaEnergija() {
        return dobivenaEnergija;
    }

    public void setDobivenaEnergija(double dobivenaEnergija) {
        this.dobivenaEnergija = dobivenaEnergija;
    }

    public double getUtrosenaEnergija() {
        return utrosenaEnergija;
    }

    public void setUtrosenaEnergija(double utrosenaEnergija) {
        this.utrosenaEnergija = utrosenaEnergija;
    }

    public double getRazlika() {
        return razlika;
    }

    public void setRazlika(double razlika) {
        this.razlika = razlika;
    }
}
