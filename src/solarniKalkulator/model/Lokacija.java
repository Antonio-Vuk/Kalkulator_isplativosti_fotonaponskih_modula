package solarniKalkulator.model;

public class Lokacija {

    private boolean indikatorGreske = false;

    private String grad;
    private int nagibKrova;
    private String orijentacija;
    private int povrsinaKrova;
    private String vrstaModula;

    public Lokacija(){}

    public Lokacija(String grad, int nagibKrova, String orijentacija, int povrsinaKrova, String vrstaModula) {
        this.grad = grad;
        this.nagibKrova = nagibKrova;
        this.orijentacija = orijentacija;
        this.povrsinaKrova = povrsinaKrova;
        this.vrstaModula = vrstaModula;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getNagibKrova() {
        return nagibKrova;
    }

    public void setNagibKrova(int nagibKrova) {
        this.nagibKrova = nagibKrova;
    }

    public String getOrijentacija() {
        return orijentacija;
    }

    public void setOrijentacija(String orijentacija) {
        this.orijentacija = orijentacija;
    }

    public int getPovrsinaKrova() {
        return povrsinaKrova;
    }

    public void setPovrsinaKrova(int povrsinaKrova) {
        this.povrsinaKrova = povrsinaKrova;
        Kalkulator.Instance().getUlog().setBrojModula(povrsinaKrova/8);
    }

    public String getVrstaModula() {
        return vrstaModula;
    }

    public void setVrstaModula(String vrstaModula) {
        this.vrstaModula = vrstaModula;
    }

    public boolean isIndikatorGreske() {
        if (this.getGrad() == null || this.getVrstaModula() == null || this.getPovrsinaKrova() == 0
                || this.getOrijentacija() == null || this.getNagibKrova() == 0){
            this.setIndikatorGreske(true);
        }else {
            this.setIndikatorGreske(false);
        }
        return indikatorGreske;
    }

    public void setIndikatorGreske(boolean indikatorGreske) {
        this.indikatorGreske = indikatorGreske;
    }
}
