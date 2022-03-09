import java.util.HashMap;

public class SkrzyniaBiegow extends Komponent{
    private int aktualnyBieg;
    private int iloscBiegow;
    private float[] przelozenia = new float[]{1.1f, 1.2f, 1.3f, 1.4f, 1.5f, 1.6f};
    private float aktualnePrzelozenie;


    public SkrzyniaBiegow(String nazwa, int waga, int cena, int aktualnyBieg, int iloscBiegow) {
        super(nazwa, waga, cena);
        this.aktualnyBieg = aktualnyBieg;
        this.iloscBiegow = iloscBiegow;


    }

    Sprzeglo sprzeglo = new Sprzeglo("sprzegło1", 20, 200, true);

    public void setAktualnePrzelozenie(){
        if(aktualnyBieg == 1){
            this.aktualnePrzelozenie = 3.3f;
        }
        if(aktualnyBieg == 2){
            this.aktualnePrzelozenie = 2.8f;
        }
        if(aktualnyBieg == 3){
            this.aktualnePrzelozenie = 2.4f;
        }
        if(aktualnyBieg == 4){
            this.aktualnePrzelozenie = 2.0f;
        }
        if(aktualnyBieg == 5){
            this.aktualnePrzelozenie = 1.5f;
        }
        if(aktualnyBieg == 6){
            this.aktualnePrzelozenie = 1.1f;
        }
    }

    public int getAktualnyBieg() {

        return aktualnyBieg;
    }

    public void setAktualnyBieg(int b){
        aktualnyBieg = b;
    }

    public int getIloscBiegow() {
        return iloscBiegow;
    }

    public float getAktualnePrzelozenie() {
        return aktualnePrzelozenie;
    }

    //public Sprzeglo getSprzeglo() {
    //    return sprzeglo;
    //}

    void zwiekszBieg(){
        if(sprzeglo.getStanSprzegla()) {
            if (aktualnyBieg < iloscBiegow) {
                aktualnyBieg = getAktualnyBieg() + 1;
            }
            else{
                System.out.println("masz już najwyższy bieg!");
            }
        }
        else {
            System.out.println("Sprzęgło nie jest wciśnięte");
        }
    }

    void zmniejszBieg(){

        if(sprzeglo.getStanSprzegla()) {
            if (aktualnyBieg!=1) {
                aktualnyBieg = getAktualnyBieg() -1;
            }
            else{
                System.out.println("masz już najniższy bieg!");
            }
        }
        else {
            System.out.println("Sprzęgło nie jest wciśnięte");
        }

    }

    
}
