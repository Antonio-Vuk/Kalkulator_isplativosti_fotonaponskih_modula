package solarniKalkulator.model;

public class Ulog {

    private boolean mjeseciIndikator = false;


    private Mjeseci mjeseci;
    private int brojModula;
    private double cijenaPoModulu = 3923;
    private double dodatnaOprema = 0;
    private int kamatnaStopa = 6;
    private double cijenaStruje = 0.67;
    private double drzavniPoticaji = 3.40;
    private double godisnjaPotrosnja = 3230;

    public Ulog(int brojModula, double cijenaPoModulu, double dodatnaOprema, int kamatnaStopa,
                double cijenaStruje, double drzavniPoticaji, double godisnjaPotrosnja) {
        this.brojModula = brojModula;
        this.cijenaPoModulu = cijenaPoModulu;
        this.dodatnaOprema = dodatnaOprema;
        this.kamatnaStopa = kamatnaStopa;
        this.cijenaStruje = cijenaStruje;
        this.drzavniPoticaji = drzavniPoticaji;
        this.godisnjaPotrosnja = godisnjaPotrosnja;
    }

    public Ulog() {
    }

    public int getBrojModula() {
        return brojModula;
    }

    public void setBrojModula(int brojModula) {
        this.brojModula = brojModula;
    }

    public double getCijenaPoModulu() {
        return cijenaPoModulu;
    }

    public void setCijenaPoModulu(double cijenaPoModulu) {
        this.cijenaPoModulu = cijenaPoModulu;
    }

    public double getDodatnaOprema() {
        return dodatnaOprema;
    }

    public void setDodatnaOprema(double dodatnaOprema) {
        this.dodatnaOprema = dodatnaOprema;
    }

    public int getKamatnaStopa() {
        return kamatnaStopa;
    }

    public void setKamatnaStopa(int kamatnaStopa) {
        this.kamatnaStopa = kamatnaStopa;
    }

    public double getCijenaStruje() {
        return cijenaStruje;
    }

    public void setCijenaStruje(double cijenaStruje) {
        this.cijenaStruje = cijenaStruje;
    }

    public double getDrzavniPoticaji() {
        return drzavniPoticaji;
    }

    public void setDrzavniPoticaji(double drzavniPoticaji) {
        this.drzavniPoticaji = drzavniPoticaji;
    }

    public double getGodisnjaPotrosnja() {
        if (this.isMjeseciIndikator()){
            setGodisnjaPotrosnja(mjeseci.getTotal());
        }
        return godisnjaPotrosnja;
    }

    public void setGodisnjaPotrosnja(double godisnjaPotrosnja) {
        this.godisnjaPotrosnja = godisnjaPotrosnja;
    }

    public Mjeseci getMjeseci() {
        if (mjeseci == null){
            mjeseci = new Mjeseci();
        }
        return mjeseci;
    }
    public void setMjeseci(Mjeseci mjeseci) {
        this.mjeseci = mjeseci;
    }

    public boolean isMjeseciIndikator() {
        return mjeseciIndikator;
    }

    public void setMjeseciIndikator(boolean mjeseciIndikator) {
        this.mjeseciIndikator = mjeseciIndikator;
    }
}
