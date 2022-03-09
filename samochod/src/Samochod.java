import javax.swing.*;

public class Samochod extends Thread{

    private int predkoscMax;
    private String model;
    private String nrRejestracji;
    private boolean stanWlaczenia; // true = on | false = off
    private int waga;
    private Silnik silnik = new Silnik("Benzyna", 20, 300, 1500, 0);
    private Pozycja aktualnaPozycja = new Pozycja(0,0);
    private SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("5 biegów manualna", 20, 5000, 1, 6);
    private Pozycja cel = new Pozycja(0,0);

    public int getAktualnaPredkosc() {
        int p = (int) (this.getSilnik().getObroty() / (this.getSkrzynia().getAktualnePrzelozenie()));
        if (p <= getPredkoscMax()){
            this.aktualnaPredkosc = (int) (this.getSilnik().getObroty() / (this.getSkrzynia().getAktualnePrzelozenie()));
            //System.out.println(getAktualnaPredkosc());
        }
        return aktualnaPredkosc;
    }

    public void setAktualnaPredkosc(int nowaPredkosc) {
        if(nowaPredkosc <= getPredkoscMax()){
            this.aktualnaPredkosc = nowaPredkosc;
        }else{
            this.aktualnaPredkosc = getPredkoscMax();
        }

    }

    private int aktualnaPredkosc;
    private int obwodKola;

    public int getPredkoscMax() {
        return predkoscMax;
    }

    public String getModel() {
        return model;
    }

    public String getNrRejestracji() {
        return nrRejestracji;
    }

    public boolean isStanWlaczenia() {
        return stanWlaczenia;
    }

    public Silnik getSilnik() {
        return silnik;
    }

    public Pozycja getAktualnaPozycja() {
        return aktualnaPozycja;
    }

    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }

    public void setPredkoscMax(int predkoscMax) {
        this.predkoscMax = predkoscMax;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNrRejestracji(String nrRejestracji) {
        this.nrRejestracji = nrRejestracji;
    }

    public void setSilnik(Silnik silnik) {
        this.silnik = silnik;
    }

    public void setSkrzynia(SkrzyniaBiegow skrzynia) {
        this.skrzynia = skrzynia;
    }

    public void setStanWlaczenia(boolean stanWlaczenia) {
        this.stanWlaczenia = stanWlaczenia;
    }

    public void setAktualnaPozycja(Pozycja aktualnaPozycja) {
        this.aktualnaPozycja = aktualnaPozycja;
    }

    void wlacz(){
        if(!stanWlaczenia){
            setStanWlaczenia(true);
            //this.start();
            }
        else{
            System.out.println("samochód był już włączony");
        }
    }
    void wylacz(){
        if(stanWlaczenia){
            setStanWlaczenia(false);
            setAktualnaPredkosc(0);
            getSilnik().setObroty(0);
            getSkrzynia().setAktualnyBieg(1);
        }
        else{
            System.out.println("samochód był już wyłączony");
        }
    }
    public String toString() {
        return getModel()+" "+getNrRejestracji();
    }

    void jedzDo(Pozycja nowaPozycja){
        if (!stanWlaczenia) {
            System.out.println("nie jest włączony - nie pojedzie");}
        else{

            if (getAktualnaPozycja().getX()!= nowaPozycja.getX()&&getAktualnaPozycja().getY()!= nowaPozycja.getY()){
                cel = new Pozycja(nowaPozycja.getX(), nowaPozycja.getY());
                System.out.println("jedź do: " + nowaPozycja.getX() + "," + nowaPozycja.getY());
            }
        }
    }



    public void run() {
        //System.out.println("Ten kod działa w wątku");
        //try {
            //double dt = 200;

            while (true) {

                if (!stanWlaczenia) {
                    //System.out.println("nie jest włączony - nie pojedzie");
                } else {
                    this.setAktualnaPredkosc((int) (this.getSilnik().getObroty() / (this.getSkrzynia().getAktualnePrzelozenie())));

                    if (aktualnaPozycja.getX() != cel.getX() && aktualnaPozycja.getY() != cel.getY()) {
                        //this.aktualnaPozycja.przemiesc(aktualnaPredkosc, dt, cel);
                        this.aktualnaPozycja.przeniesc(cel, 70, aktualnaPredkosc);
                        //System.out.println();

                    }

                    //Thread t = new Thread();
                    //System.out.println(this.model + " " + this.aktualnaPozycja.w());


                    // SPRAWDZIC KIEDY DOCIERA DO CELU
                    if (Math.sqrt(Math.pow(this.aktualnaPozycja.getX() - cel.getX(), 2)) == 0) {
                        //System.out.println("dojechał do celu");
                        this.setAktualnaPredkosc(0);
                        this.getSkrzynia().setAktualnyBieg(1);
                        this.getSilnik().setObroty(0);

                    }
                }

                //this.aktualnaPozycja.wypisz();

                // ułatwia dotarcie do celu -
                try {
                    Thread.sleep(50);

                } catch (Exception e) {
                    System.out.println("przerwany wątek");
                    //interrupt();
                    return;
                }
            }}

    int getObwodKola() { return obwodKola;}
    int getWaga(){
        return waga;
    }
    int getAktPredkosc(){
        return 0;
    }
    //float[] getAktPozycja(){
    //    return new float[]{aktualnaPozycja.getX(),aktualnaPozycja.getY()};
    //}

    public Samochod(String s, String model, String nrRejestracji, int waga, int obwK){
        this.predkoscMax = 115;
        this.model = "Fiat 126p";
        this.nrRejestracji = "KR0F126P";
        this.stanWlaczenia = false;
        this.waga = 615;
        this.obwodKola = 150;
        this.aktualnaPredkosc = 100;
        this.setAktualnaPozycja(new Pozycja(0,0));
        this.cel = new Pozycja(0,0);
        start();

    }

    public Samochod(int predkoscMax, String model, String nrRejestracji, int waga, int obwK) {
        this.predkoscMax = predkoscMax;
        this.model = model;
        this.nrRejestracji = nrRejestracji;
        this.stanWlaczenia = false;
        this.waga = waga;
        this.obwodKola = obwK;
        this.aktualnaPredkosc = 0;
        this.start();
    }




}
