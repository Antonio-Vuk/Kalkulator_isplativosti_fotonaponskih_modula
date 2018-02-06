package solarniKalkulator.model;

public class Mjeseci {
    private double total;
    private double sijecanj;
    private double veljaca;
    private double ozuljak;
    private double travanj;
    private double svibanj;
    private double lipanj;
    private double srpanj;
    private double kolovoz;
    private double rujan;
    private double listopad;
    private double stdeni;
    private double prosinac;

    public Mjeseci() {
    }

    public double getSijecanj() {
        return sijecanj;
    }

    public void setSijecanj(double sijecanj) {
        this.sijecanj = sijecanj;
    }

    public double getVeljaca() {
        return veljaca;
    }

    public void setVeljaca(double veljaca) {
        this.veljaca = veljaca;
    }

    public double getOzuljak() {
        return ozuljak;
    }

    public void setOzuljak(double ozuljak) {
        this.ozuljak = ozuljak;
    }

    public double getTravanj() {
        return travanj;
    }

    public void setTravanj(double travanj) {
        this.travanj = travanj;
    }

    public double getSvibanj() {
        return svibanj;
    }

    public void setSvibanj(double svibanj) {
        this.svibanj = svibanj;
    }

    public double getLipanj() {
        return lipanj;
    }

    public void setLipanj(double lipanj) {
        this.lipanj = lipanj;
    }

    public double getSrpanj() {
        return srpanj;
    }

    public void setSrpanj(double srpanj) {
        this.srpanj = srpanj;
    }

    public double getKolovoz() {
        return kolovoz;
    }

    public void setKolovoz(double kolovoz) {
        this.kolovoz = kolovoz;
    }

    public double getRujan() {
        return rujan;
    }

    public void setRujan(double rujan) {
        this.rujan = rujan;
    }

    public double getListopad() {
        return listopad;
    }

    public void setListopad(double listopad) {
        this.listopad = listopad;
    }

    public double getStdeni() {
        return stdeni;
    }

    public void setStdeni(double stdeni) {
        this.stdeni = stdeni;
    }

    public double getProsinac() {
        return prosinac;
    }

    public void setProsinac(double prosinac) {
        this.prosinac = prosinac;
    }

    public double getTotal() {
        double ukupno;
        ukupno = sijecanj + veljaca + ozuljak + travanj + svibanj + lipanj + srpanj + kolovoz + rujan + listopad +
                stdeni + prosinac;
        setTotal(ukupno);
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
