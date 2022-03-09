public class SamochodTest {

    public static void main(String[] args) throws InterruptedException {

        //Samochod car1 = new Samochod();
        Samochod car2 = new Samochod(220, "Ford Fiesta", "KGR12L09", 1500, 200);
        //car2.setAktualnaPozycja(new Pozycja(500,500));
        car2.wlacz();
        //car1.wlacz();
        //car1.setAktualnaPredkosc(car2.getAktualnaPredkosc());
        //car1.jD(new Pozycja(180,50));
        car2.jedzDo(new Pozycja(6,6));
        //car1.start();
        //car2.wlacz();
        //car2.jD(new Pozycja(110,250));
        //car2.jedzDo(new Pozycja(200,350));
        //car1.jedzDo(new Pozycja(200,350)); // nie jedzie bo aktualna predkosc rowna zero


    }
}
