package solarniKalkulator.model;

public  class Kalkulator {
    private static Kalkulator instance = null;

    private Lokacija lokacija;
    private Ulog ulog;
    private Izracun izracun;


    protected Kalkulator(){
        // Exists only to defeat instantiation.
    }

    public static Kalkulator Instance(){
        if (instance == null){
            instance = new Kalkulator();
        }
        return instance;
    }

    public Lokacija getLokacija() {
        if (lokacija == null){
            lokacija = new Lokacija();
        }
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public Ulog getUlog() {
        if (ulog == null){
            ulog = new Ulog();
        }
        return ulog;
    }

    public void setUlog(Ulog ulog) {
        this.ulog = ulog;
    }

    public Izracun getIzracun() {
        if (izracun == null){
            izracun = new Izracun();
        }
        return izracun;
    }

    public void setIzracun(Izracun izracun) {
        this.izracun = izracun;
    }
}
