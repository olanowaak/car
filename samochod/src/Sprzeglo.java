public class Sprzeglo extends Komponent{

    private boolean stanSprzegla;

    public void setStanSprzegla(boolean stanSprzegla) {
        this.stanSprzegla = stanSprzegla;
    }

    public boolean getStanSprzegla(){
        return stanSprzegla;
    }

    public String getStrStanSprzegla() {
        String stringStanSprzegla;
        if(stanSprzegla){
            stringStanSprzegla = new String("sprzęgło wciśnięte");
        }
        else{
            stringStanSprzegla = new String("sprzęgło nie jest wciśnięte");
        }
        return stringStanSprzegla;
    }

    public Sprzeglo(String nazwa, int waga, int cena, boolean stanSprzegla) {
        super(nazwa, waga, cena);
        this.setStanSprzegla(stanSprzegla);
    }

    void wcisnij(){
        stanSprzegla = true;
    }
    void zwolnij(){
        stanSprzegla = false;
    }
}
