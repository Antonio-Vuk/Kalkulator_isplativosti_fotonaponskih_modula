package solarniKalkulator.model;

public class FinalIzracun {
    private double dobiciOdPoticaja;
    private double cijenaUgradnje;
    private double izdaciZaStruju;
    private double ukupno;

    public FinalIzracun(double dobiciOdPoticaja, double cijenaUgradnje, double izdaciZaStruju, double ukupno) {
        this.dobiciOdPoticaja = dobiciOdPoticaja;
        this.cijenaUgradnje = cijenaUgradnje;
        this.izdaciZaStruju = izdaciZaStruju;
        this.ukupno = ukupno;
    }

    public FinalIzracun() {
    }

    public double getDobiciOdPoticaja() {
        return dobiciOdPoticaja;
    }

    public void setDobiciOdPoticaja(double dobiciOdPoticaja) {
        this.dobiciOdPoticaja = dobiciOdPoticaja;
    }

    public double getCijenaUgradnje() {
        return cijenaUgradnje;
    }

    public void setCijenaUgradnje(double cijenaUgradnje) {
        this.cijenaUgradnje = cijenaUgradnje;
    }

    public double getIzdaciZaStruju() {
        return izdaciZaStruju;
    }

    public void setIzdaciZaStruju(double izdaciZaStruju) {
        this.izdaciZaStruju = izdaciZaStruju;
    }

    public double getUkupno() {
        return ukupno;
    }

    public void setUkupno(double ukupno) {
        this.ukupno = ukupno;
    }
}
