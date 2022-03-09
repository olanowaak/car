public class Silnik extends Komponent{

    private int maxObroty;
    private int obroty;


    public int getMaxObroty() {
        return maxObroty;
    }

    public void setMaxObroty(int maxObroty) {
        this.maxObroty = maxObroty;
    }

    public int getObroty() {
        return obroty;
    }

    public void setObroty(int obroty) {
        this.obroty = obroty;
    }

    public Silnik(String nazwa, int waga, int cena, int maxObroty, int obroty) {
        super(nazwa, waga, cena);
        this.setMaxObroty(maxObroty);
        this.setObroty(obroty);
    }

    void uruchom(){
        this.setObroty(obroty);


    }
    void zatrzymaj(){
        this.setObroty(0);

    }
    void zwiekszObroty(){
        if(this.getObroty() < getMaxObroty()) {
            this.setObroty(this.getObroty() + 100);
        }

    }
    void zmniejszObroty(){
        if(this.getObroty() > 0){
            this.setObroty(this.getObroty() - 100);
        }

    }
}
