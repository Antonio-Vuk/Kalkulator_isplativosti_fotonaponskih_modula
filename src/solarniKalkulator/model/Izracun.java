package solarniKalkulator.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Izracun {
    ArrayList<String> listaMjeseci = new ArrayList<>();
    ArrayList<Double> proizvodnjaPo1KwLista = new ArrayList<>();
    final double kvocjent = 4.28;
    final double poticajPoKomadu = 16368.45;
    final double potrosnja = 25969;
    ArrayList<Double> dobivenaEnergijaLista = new ArrayList<>();
    ArrayList<Double> utrosenaEnergijaLista = new ArrayList<>();
    ArrayList<Double> razlikaLista = new ArrayList<>();
    private double nakgibKrova;
    private double orijentacija;
    private FinalIzracun izracun1;
    private FinalIzracun izracun2;
    private int minBrojPotrebnihModula = 9;

    public void loadData(){
        DecimalFormat df = new DecimalFormat("#.##");
        listaMjeseci.clear();
        proizvodnjaPo1KwLista.clear();
        dobivenaEnergijaLista.clear();
        utrosenaEnergijaLista.clear();
        razlikaLista.clear();

        if (Kalkulator.Instance().getLokacija().getNagibKrova() == 45){
            nakgibKrova = 1;
        }else if(Kalkulator.Instance().getLokacija().getNagibKrova() == 60){
            nakgibKrova = 1.1;
        }else {
            minBrojPotrebnihModula+=1;
            nakgibKrova = 1.05;
        }

        if (Kalkulator.Instance().getLokacija().getOrijentacija().equalsIgnoreCase("jug")){
            orijentacija = 1;
        }else if(Kalkulator.Instance().getLokacija().getOrijentacija().equalsIgnoreCase("Jugoistok")){
            orijentacija = 1.05;
        }else if(Kalkulator.Instance().getLokacija().getOrijentacija().equalsIgnoreCase("Jugozapad")){
            orijentacija = 1.1;
        }else if(Kalkulator.Instance().getLokacija().getOrijentacija().equalsIgnoreCase("Istok")){
            minBrojPotrebnihModula+=1;
            orijentacija = 1.15;
        }else{
            minBrojPotrebnihModula+=1;
            orijentacija = 1.05;
        }

        listaMjeseci.add("siječanj");
        listaMjeseci.add("veljača");
        listaMjeseci.add("ožujak");
        listaMjeseci.add("travanj");
        listaMjeseci.add("svibanj");
        listaMjeseci.add("lipanj");
        listaMjeseci.add("srpanj");
        listaMjeseci.add("kolovoz");
        listaMjeseci.add("rujan");
        listaMjeseci.add("listopad");
        listaMjeseci.add("studeni");
        listaMjeseci.add("prosinac");

        if (Kalkulator.Instance().getLokacija().getGrad().equalsIgnoreCase("Gospić")){
            proizvodnjaPo1KwLista.add(39.83 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(223.59 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(117.67 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(37.06 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(125.61 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(48.38 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(63.94 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(141.88 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(27.43 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(161.68 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(106.72 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(30.53 * nakgibKrova * orijentacija);
        }else if(Kalkulator.Instance().getLokacija().getGrad().equalsIgnoreCase("Varaždin")){
            proizvodnjaPo1KwLista.add(43.55 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(58.98 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(88.19 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(100.81 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(110.60 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(111.85 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(118.74 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(112.85 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(101.98 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(77.21 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(43.57 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(33.11 * nakgibKrova * orijentacija);
        }else{
            proizvodnjaPo1KwLista.add(34.88 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(47.89 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(83.38 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(98.23 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(113.12 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(114.21 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(124.58 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(114.68 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(101.92 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(73.62 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(38.51 * nakgibKrova * orijentacija);
            proizvodnjaPo1KwLista.add(25.36 * nakgibKrova * orijentacija);
            minBrojPotrebnihModula+=1;
        }

        for (int i = 0; i < proizvodnjaPo1KwLista.size(); i++){
            dobivenaEnergijaLista.add(proizvodnjaPo1KwLista.get(i) * kvocjent);
        }

        if (Kalkulator.Instance().getUlog().isMjeseciIndikator()){
            utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getMjeseci().getSijecanj());
            utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getMjeseci().getVeljaca());
            utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getMjeseci().getOzuljak());
            utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getMjeseci().getTravanj());
            utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getMjeseci().getSvibanj());
            utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getMjeseci().getLipanj());
            utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getMjeseci().getSrpanj());
            utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getMjeseci().getKolovoz());
            utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getMjeseci().getRujan());
            utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getMjeseci().getListopad());
            utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getMjeseci().getStdeni());
            utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getMjeseci().getProsinac());
        }else{
            for (int i = 0; i < proizvodnjaPo1KwLista.size(); i++){
                utrosenaEnergijaLista.add(Kalkulator.Instance().getUlog().getGodisnjaPotrosnja()/12);
            }
        }

        for (int i = 0; i < proizvodnjaPo1KwLista.size(); i++){
            razlikaLista.add(dobivenaEnergijaLista.get(i) - utrosenaEnergijaLista.get(i) );
        }
        for (int i = 0; i < proizvodnjaPo1KwLista.size(); i++){
            proizvodnjaPo1KwLista.set(i, Double.valueOf(df.format(proizvodnjaPo1KwLista.get(i))));
            dobivenaEnergijaLista.set(i, Double.valueOf(df.format(dobivenaEnergijaLista.get(i))));
            utrosenaEnergijaLista.set(i, Double.valueOf(df.format(utrosenaEnergijaLista.get(i))));
            razlikaLista.set(i, Double.valueOf(df.format(razlikaLista.get(i))));
        }
        getIzracun1().setDobiciOdPoticaja(
                Double.valueOf(df.format(
                        Kalkulator.Instance().getUlog().getBrojModula() * poticajPoKomadu
                ))
        );
        getIzracun1().setCijenaUgradnje(
                Double.valueOf(df.format(
                        Kalkulator.Instance().getUlog().getBrojModula() *
                                Kalkulator.Instance().getUlog().getCijenaPoModulu() +
                                Kalkulator.Instance().getUlog().getDodatnaOprema()
                ))
        );

        getIzracun1().setIzdaciZaStruju(
                Double.valueOf(df.format(
                        Kalkulator.Instance().getIzracun().getIzracun1().getCijenaUgradnje() + 25969
                ))
        );
        getIzracun1().setUkupno(
                Double.valueOf(df.format(
                        Kalkulator.Instance().getIzracun().getIzracun1().getCijenaUgradnje() +
                                Kalkulator.Instance().getIzracun().getIzracun1().getIzdaciZaStruju()
                ))
        );

        getIzracun2().setDobiciOdPoticaja(
                Double.valueOf(df.format(
                        minBrojPotrebnihModula * poticajPoKomadu
                ))
        );
        getIzracun2().setCijenaUgradnje(
                Double.valueOf(df.format(
                        minBrojPotrebnihModula * Kalkulator.Instance().getUlog().getCijenaPoModulu() +
                                Kalkulator.Instance().getUlog().getDodatnaOprema()
                ))
        );

        getIzracun2().setIzdaciZaStruju(
                Double.valueOf(df.format(
                        Kalkulator.Instance().getIzracun().getIzracun2().getCijenaUgradnje() + 25969
                ))
        );
        getIzracun2().setUkupno(
                Double.valueOf(df.format(
                        Kalkulator.Instance().getIzracun().getIzracun2().getCijenaUgradnje() +
                                Kalkulator.Instance().getIzracun().getIzracun2().getIzdaciZaStruju()
                ))
        );
    }

    public double ukupniZbrojListe(ArrayList<Double> list){
        Double suma = 0.0;
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < list.size(); i++){
            suma += list.get(i);
        }
        return Double.valueOf(df.format(suma));
    }

    public void printajString(ArrayList<String> lista){
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
        System.out.println("-----------------------");
    }

    public void printaj(ArrayList<Double> lista){
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
        System.out.println("-----------------------");
    }

    public ArrayList<String> getListaMjeseci() {
        return listaMjeseci;
    }

    public void setListaMjeseci(ArrayList<String> listaMjeseci) {
        this.listaMjeseci = listaMjeseci;
    }
    public ArrayList<Double> getProizvodnjaPo1KwLista() {
        return proizvodnjaPo1KwLista;
    }

    public void setProizvodnjaPo1KwLista(ArrayList<Double> proizvodnjaPo1KwLista) {
        this.proizvodnjaPo1KwLista = proizvodnjaPo1KwLista;
    }

    public double getKvocjent() {
        return kvocjent;
    }

    public ArrayList<Double> getDobivenaEnergijaLista() {
        return dobivenaEnergijaLista;
    }

    public void setDobivenaEnergijaLista(ArrayList<Double> dobivenaEnergijaLista) {
        this.dobivenaEnergijaLista = dobivenaEnergijaLista;
    }

    public ArrayList<Double> getUtrosenaEnergijaLista() {
        return utrosenaEnergijaLista;
    }

    public void setUtrosenaEnergijaLista(ArrayList<Double> utrosenaEnergijaLista) {
        this.utrosenaEnergijaLista = utrosenaEnergijaLista;
    }

    public ArrayList<Double> getRazlikaLista() {
        return razlikaLista;
    }

    public void setRazlikaLista(ArrayList<Double> razlikaLista) {
        this.razlikaLista = razlikaLista;
    }
    public FinalIzracun getIzracun1() {
        if (izracun1 == null){
            izracun1 = new FinalIzracun();
        }
        return izracun1;
    }

    public void setIzracun1(FinalIzracun izracun1) {
        this.izracun1 = izracun1;
    }

    public FinalIzracun getIzracun2() {
        if (izracun2 == null){
            izracun2 = new FinalIzracun();
        }
        return izracun2;
    }

    public void setIzracun2(FinalIzracun izracun2) {
        this.izracun2 = izracun2;
    }

    public int getMinBrojPotrebnihModula() {
        return minBrojPotrebnihModula;
    }

    public void setMinBrojPotrebnihModula(int minBrojPotrebnihModula) {
        this.minBrojPotrebnihModula = minBrojPotrebnihModula;
    }
}
